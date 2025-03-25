import { useState } from 'react';
import Lennujaamad from './Lennujaamad.jsx'
import Lennud from './Lennud.jsx'
import DatePicker from "react-datepicker";

import "react-datepicker/dist/react-datepicker.css";
import './App.css'

function App() {

  const[väljumiskuupäev, setväljumiskuupäev] = useState(new Date());

  return (
    <>
      <label htmlFor='algpunkt'>Vali algpunkt</label>
      <Lennujaamad name='algpunkt' id='algpunkt' />
      <br/>
      <label htmlFor='sihtpunkt'>Vali sihtpunkt</label>
      <Lennujaamad name='sihtpunkt' id='sihtpunkt'/>
      <br />
      <label>Vali kuupäev</label>
      <DatePicker selected={väljumiskuupäev} onChange={(päev) => setväljumiskuupäev(päev)} />
      <Lennud />
    </>
  )
}

export default App
