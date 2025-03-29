import { useState, useEffect } from "react";

function Lennud(props) {
    let [lennud, leiaLennud] = useState([]);

    const filter = { algpunkt: props.algpunkt, sihtpunkt: props.sihtpunkt, aeg: props.väljumiskuupäev };

    function värksendaLende() {
      if (props.algpunkt != null && props.sihtpunkt != null && props.väljumiskuupäev != null) {
        fetch("http://localhost:8080/api/lennud/filtreeri", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(filter),
        }).then(response => response.json())
        .then(data => {leiaLennud(data)})
        .catch(error => console.error("Viga API päringus:", error))
      }
    }

    function ainultAeg(kuupäevJaAeg) {
      let pooleks = kuupäevJaAeg.split("T");
      return pooleks[1];
    }

    return (
        <>
          <br />
          <button onClick={värksendaLende}>Otsi</button>
          <p>Leiti {lennud.length} lendu</p>
          {lennud.map((lend) => (
            <>
              <br />
              <input type="radio" id={lend.id} name="lennuvalikud" value={lend.id} checked={props.valitudLend == lend.id} onChange={(e) => props.onChange(e.target.value)}></input>
              <label htmlFor={lend.id}>{ainultAeg(lend.väljumisaeg)} {lend.piletihind}€</label>
            </>
          ))}
        </>
    )
}

export default Lennud