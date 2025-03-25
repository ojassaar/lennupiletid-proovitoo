import { useState, useEffect } from "react";

function Lennud(props) {
    let [lennud, leiaLennud] = useState([]);

    const filter = { kuupaev: "2025-03-25", sihtkoht: "TLL" };

    useEffect(() => {
        fetch("http://localhost:8080/api/lennud/filtreeri", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(filter),
        })
        .then(response => response.json())
        .then(data => leiaLennud(data))
        .catch(error => console.error("Viga API päringus:", error));
    }, []);

    return (
        <>
          {lennud.map((lend) => (
            <>
              <input type="radio" name={lend.id} value={lend.id}></input>
              <label name={lend.id}>{lend.väljumisaeg}</label>
            </>
          ))}
        </>
    )
}

export default Lennud

/*

function Lennujaamad(props) {

    let [lennujaamad, leiaLennujaamad] = useState([]);

    useEffect(() => {
            fetch("http://localhost:8080/api/lennujaamad")
                .then(response => response.json())
                .then(data => leiaLennujaamad(data))
                .catch(error => console.error("Viga andmete laadimisel:", error));
        }, []);

    return (
        <>
          <select onChange={(e) => onSelect(e.target.value)} name={props.name} id={props.id}>
            <option value="">Vali {props.name}</option>
            {lennujaamad.map((jaam) => (
                <option value={jaam.kood}>{jaam.kood} {jaam.nimi}</option>
            ))}
          </select>
        </>
    )
}

export default Lennujaamad
*/