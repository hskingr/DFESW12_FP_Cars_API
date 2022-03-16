import logo from './logo.svg';
import './App.css';
import React from 'react'
import TBox from './components/TBox.jsx'
import Choice from './components/Choices.jsx'
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
const options = [
  { label: 'Create', value: 'create'}, {
    label: 'Read', value: 'read'}, {
    label: 'Update', value: 'update'}, {
    label: 'Delete', value: 'delete'},
]

  const [value, setValue] = React.useState('create');


  const handleChange = (event) => {
    setValue(event.target.value);
  };

  return (
    <div className="App">
      <header className="App-header">
      <div>
      <select value={value} onChange={handleChange}>
      {options.map((option) => (
        <option value={option.value}>{option.label}</option>
      ))}
      </select>

      <p> Selected {value}</p>
    </div>

         <TBox />
      </header>

    </div>
  );
}

const  apiCall = () => {
  state = {
    cars: []
  }
  componentDidMount = async () => {
    try {
      const res = fetch('http://localhost:8080/readItem/1')
      const resJ = await res.json()
      const data = await this.setState({cars: data})
      console.log(data)
    } catch (error) {
      console.log(error)
    }

  }


}

export default App;
