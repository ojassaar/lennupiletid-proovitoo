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
          <select name={props.name} id={props.id}>
                {lennujaamad.map((jaam) => <option value={jaam.kood}>{jaam.kood}</option>)}
          </select>
        </>
    )
}

export default Lennujaamad