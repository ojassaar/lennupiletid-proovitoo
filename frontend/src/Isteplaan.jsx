import './isteplaan.css';
import { useState, useEffect } from "react";

// suurema osa tegi tehisaru

function LennukiIsteplaan(props) {
    const [maatriks, setMaatriks] = useState([]);
    const [lennud, setLennud] = useState([]);
    const [reloadCount, setReloadCount] = useState(0);
    const[vahekäiguKõrval, setVahekäiguKõrval] = useState(-1);
    const[laius, setLaius] = useState(0);
    const[väljapääsuRida, setVäljapääsuRida] = useState(-1);
    const[ühePiletiHind, setÜhePiletiHind] = useState(0);
    const[valitudPiletiteArv, setValitudPiletiteArv] = useState(0);

    const filter = { id: props.lennuId };

    useEffect(() => {
        if (!props.lennuId) return;

        async function looLennuPõhjalMaatriks() {
            try {
                const lend = await leiaLend();
                const m = looMaatriks(lend);
                setMaatriks(m);
            } catch (error) {
                console.error("Viga: ", error);
            }
        }

        looLennuPõhjalMaatriks();
    }, [props.lennuId, reloadCount]); // Käivita, kui ID muutub või reload vajutatakse

    function looMaatriks(lend) {
        let istekohad = lend.istekohad;
        let pikkus = lend.lennuk.istmeridu;
        setLaius(lend.lennuk.vasakulIstmeid + lend.lennuk.paremalIstmeid);
        setVahekäiguKõrval(lend.lennuk.vasakulIstmeid);
        setVäljapääsuRida(lend.lennuk.väljapääsuRida);
        setÜhePiletiHind(lend.piletihind);
        setValitudPiletiteArv(0);

        let uusMaatriks = [];
        let i = 0;
        for (let rida = 0; rida < pikkus; rida++) {
            uusMaatriks.push([]);
            for (let koht = 0; koht < laius; koht++) {
                let lisatav = istekohad[i].saadaval ? 0 : 1;
                i++;
                uusMaatriks[rida].push(lisatav);
            }
        }
        return uusMaatriks;
    }

    async function leiaLend() {
        const response = await fetch("http://localhost:8080/api/lennud/id", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(filter),
        });

        const data = await response.json();
        setLennud(data);
        return data[0];
    }

    const valiKoht = (rida, koht) => {
        if (maatriks[rida][koht] === 1) return;
    
        const uusMaatriks = maatriks.map((r, i) => {
            if (i === rida) {
                return r.map((v, j) => {
                    if (j === koht) {
                        if (v === 2) {
                            setValitudPiletiteArv(a => a - 1);
                            return 0;
                        } else {
                            setValitudPiletiteArv(a => a + 1);
                            return 2;
                        }
                    } else {
                        return v;
                    }
                });
            } else {
                return r;
            }
        });
    
        setMaatriks(uusMaatriks);
    };
    

    const kinnitaValik = () => {
        const valitudKohad = [];
        maatriks.forEach((rida, ridaIndex) => {
            rida.forEach((koht, kohtIndex) => {
                if (koht === 2) {
                    let index = ridaIndex * laius + kohtIndex;
                    valitudKohad.push(index);
                }
            });
        });

        const lendJaPiletid = {lend: props.lennuId, piletid: valitudKohad};
    
        fetch("http://localhost:8080/api/broneeri", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(lendJaPiletid),
        })
        .then(response => response.text())
        .then(data => {
            setReloadCount(prev => prev + 1);
        })
        .catch(error => console.error("Viga broneerimisel:", error));
    };
    

    return (
        <div>
            <p>Pileteid: {valitudPiletiteArv}, Summa: {valitudPiletiteArv * ühePiletiHind}€</p>
            <button onClick={kinnitaValik}>Kinnita piletid</button>
            <button onClick={() => setReloadCount(c => c + 1)}>Laadi uuesti</button>
            <div className="isteplaan" style={{gridTemplateColumns: 'repeat(' + laius + ', 50px)'}}>
                {maatriks.map((rida, ridaIndex) =>
                    rida.map((koht, kohtIndex) => (
                        <button
                            key={`${ridaIndex}-${kohtIndex}`}
                            onClick={() => valiKoht(ridaIndex, kohtIndex)}
                            className={`iste ${
                                koht === 1 ? "hõivatud" :
                                koht === 2 ? "valitud" :
                                "vaba"
                            }`}
                            style={{ marginLeft: kohtIndex >= vahekäiguKõrval ? '10px' : '0px',
                                marginTop: ridaIndex == väljapääsuRida - 1 ? '20px' : '0px'}}
                        >
                            {String.fromCharCode(65 + kohtIndex)}
                            {ridaIndex + 1}
                        </button>
                    ))
                )}
            </div>
        </div>
    );
}

export default LennukiIsteplaan;
