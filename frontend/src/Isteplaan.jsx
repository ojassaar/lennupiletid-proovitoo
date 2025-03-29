import './isteplaan.css';

import { useState } from "react";

function LennukiIsteplaan({ read = 6, kohadReas = 4 }) {
    // Näidis: 0 = vaba, 1 = hõivatud, 2 = valitud
    const [istekohad, setIstekohad] = useState([
        [0, 1, 0, 0],
        [0, 0, 1, 0],
        [1, 0, 0, 0],
        [0, 0, 0, 1],
        [0, 0, 0, 0],
        [0, 1, 1, 0]
    ]);

    // Kasutaja valib koha
    const valiKoht = (rida, koht) => {
        if (istekohad[rida][koht] === 1) return; // Hõivatud kohta ei saa valida
        const uusIstekohad = istekohad.map((r, i) =>
            i === rida ? r.map((v, j) => (j === koht ? (v === 2 ? 0 : 2) : v)) : r
        );
        setIstekohad(uusIstekohad);
    };

    return (
        <div className="isteplaan">
            {istekohad.map((rida, ridaIndex) =>
                rida.map((koht, kohtIndex) => (
                    <button
                        key={`${ridaIndex}-${kohtIndex}`}
                        onClick={() => valiKoht(ridaIndex, kohtIndex)}
                        className={`iste ${
                            koht === 1 ? "hõivatud" : // Hõivatud
                            koht === 2 ? "valitud" : // Valitud
                            "vaba" // Vaba
                        }`}
                    >
                        {String.fromCharCode(65 + kohtIndex)}
                        {ridaIndex + 1}
                    </button>
                ))
            )}
        </div>
    );
};

export default LennukiIsteplaan;
