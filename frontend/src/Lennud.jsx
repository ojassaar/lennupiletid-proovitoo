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
        .then(data => {console.log("andmed on: ", data); leiaLennud(data)})
        .catch(error => console.error("Viga API päringus:", error))
        .then(console.log("filter: ", filter));
      }
    }

    return (
        <>
          <br />
          <button onClick={värksendaLende}>Otsi</button>
          <p>Leiti {lennud.length} lendu</p>
          {lennud.map((lend) => (
            <>
              <br />
              <input type="radio" id={lend.id} name="lennud" value={lend.id}></input>
              <label for={lend.id}>{lend.väljumisaeg}</label>
            </>
          ))}
        </>
    )
}

export default Lennud