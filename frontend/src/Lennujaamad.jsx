import { useState, useEffect } from "react";

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
          <select onChange={(e) => props.onSelect(e.target.value)} name={props.name} id={props.id}>
            <option value="">Vali {props.name}</option>
            {lennujaamad.map((jaam, index) => (
                <option value={index + 1}>{jaam.kood} {jaam.nimi}</option>
            ))}
          </select>
        </>
    )
}

export default Lennujaamad