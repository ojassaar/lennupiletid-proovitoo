import { useState } from 'react';
import Lennujaamad from './Lennujaamad.jsx'
import Lennud from './Lennud.jsx'
import DatePicker from "react-datepicker";

import "react-datepicker/dist/react-datepicker.css";
import './App.css'

function App() {

  const[väljumiskuupäev, setväljumiskuupäev] = useState(new Date());
  const[sihtpunkt, setSihtpunkt] = useState(null);
  const[algpunkt, setAlgpunkt] = useState(null);
  const[valitudLend, setValitudLend] = useState("");

  return (
    <>
      <label htmlFor='algpunkt'>Vali algpunkt</label>
      <Lennujaamad name='algpunkt' id='algpunkt' onSelect={setAlgpunkt} />
      <br/>
      <label htmlFor='sihtpunkt'>Vali sihtpunkt</label>
      <Lennujaamad name='sihtpunkt' id='sihtpunkt' onSelect={setSihtpunkt} />
      <br />
      <label>Vali kuupäev</label>
      <DatePicker selected={väljumiskuupäev} onChange={(päev) => setväljumiskuupäev(päev)} />
      <Lennud algpunkt={algpunkt} sihtpunkt={sihtpunkt} väljumiskuupäev={väljumiskuupäev} valitudLend={valitudLend} onChange={setValitudLend} />
      <p>{valitudLend}</p>
    </>
  )
}

export default App
