async function crudCreate(data) {
  try {
    const http = new simpleFETCH;
    const res = await http.post(`http://localhost:8080/createItem/`, data, createOpts)
    console.log(res)
    return res
  } catch (error) {
    console.log(error)
  }
}


async function crudRead(id) {
  try {
    const http = new simpleFETCH;
    const res = await http.get(`http://localhost:8080/readItem/${id}`, headerOpts)
    return res
  } catch (error) {
    console.log(error)
  }
}

async function crudReadByYear(year) {
  try {
    const http = new simpleFETCH;

    const res = await http.get(`http://localhost:8080/findItemsByYear/${year}`, headerOpts)
    return res
  } catch (error) {
    console.log(error)
  }
}

async function crudReadByModel(model) {
  try {
    const http = new simpleFETCH;

    const res = await http.get(`http://localhost:8080/findItemsByModel/${model}`, headerOpts)
    return res
  } catch (error) {
    console.log(error)
  }
}

async function crudReadByMake(make) {
  try {
    const http = new simpleFETCH;
    console.log(make)
    const res = await http.get(`http://localhost:8080/findItemsByMake/${make}`, headerOpts)
    console.log(res)
    return res
  } catch (error) {
    console.log(error)
  }
}

async function crudUpdate(id, data) {
  try {
    const http = new simpleFETCH;

    const res = await http.put(`http://localhost:8080/updateItem/${id}`, data, headerOpts)
    console.log(res)
    return res
  } catch (error) {
    console.log(error)
  }
}

async function crudDelete(id) {
  try {
    const http = new simpleFETCH;

    const res = await http.delete(`http://localhost:8080/deleteItem/${id}`, headerOpts)
    console.log(res)
    return res
  } catch (error) {
    console.log(error)
  }
}

const createData = {
  year: 1994,
  model: `Ford`,
  make: `Model TT`
}

const updateData = {
  year: 1994,
  model: `Fordy`,
  make: `Model TTy`
}


const headerOpts = {
  mode: `cors`,
  referrerPolicy: 'no-referrer',
  headers: {
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
  }
}



async function methodChanged(x) {
  try {

    switch (x) {
      case "post":
        const option7 = document.createElement('option')
        option7.value = 7
        option7.innerHTML = `http://localhost:8080/readItem/ `
        // document.getElementById("apiUrl").value = `http://localhost/`
        break
      case "get":
        // document.getElementById("apiUrl").value = `http://localhost/readItem/   `
        select = document.getElementById("apiUrl")
        select.innerHTML = ''
        const option1 = document.createElement('option')
        option1.value = 1
        option1.innerHTML = `http://localhost:8080/readItem/ `
        const option2 = document.createElement('option')
        option2.value = 2
        option2.innerHTML = `http://localhost:8080/findItemsByYear/ `
        const option3 = document.createElement('option')
        option3.value = 3
        option3.innerHTML = `http://localhost:8080/findItemsByMake/ `
        const option4 = document.createElement('option')
        option4.value = 4
        option4.innerHTML = `http://localhost:8080/findItemsByModel/ `
        select.appendChild(option1)
        select.appendChild(option2)
        select.appendChild(option3)
        select.appendChild(option4)
        break
      case "put":
        console.log(x)
        const option5 = document.createElement('option')
        option5.value = 5
        option5.innerHTML = `http://localhost:8080/readItem/ `
        document.getElementById("apiUrl").value = `http://localhost/`
        break
      case "delete":
        const option6 = document.createElement('option')
        option6.value = 6
        option6.innerHTML = `http://localhost:8080/readItem/ `
        console.log(x)
        document.getElementById("apiUrl").value = `http://localhost/`
    }
  } catch (error) {
    console.log(error)
  }

}

async function createResponse(resData) {
  try {

    document.getElementById('cards').innerHTML = ''
    if (resData.length > 0) {
      resData.forEach(item => {
        const card = document.createElement('div')
        card.className = 'card'
        card.style = 'width: 18rem'
        const cardBody = document.createElement('div')
        cardBody.className = "card-body"
        const model = document.createElement('h5')
        model.className = 'card-title'
        model.innerHTML = item.model
        const make = document.createElement('h4')
        make.className = 'card-subtitle mb-2 text-muted'
        make.innerHTML = item.make
        const year = document.createElement('p')
        year.className = 'card-text'
        year.innerHTML = `year ${item.year} and id ${item.id}`

        cardBody.appendChild(model)
        cardBody.appendChild(make)
        cardBody.appendChild(year)
        card.appendChild(cardBody)
        document.getElementById('cards').appendChild(card)
      })
    }
  } catch (error) {
    console.log(error)
  }
}

async function submitRequest() {
  try {
    chosenOpt = document.getElementById("apiUrl").value
    switch (chosenOpt) {
      case '1':
        singleInput = document.getElementById("singleMethod")
        await createResponse(await crudRead(singleInput.value))
        break
      case '2':
        singleInput = document.getElementById("singleMethod")
        await createResponse(await crudReadByYear(singleInput.value))
        break
      case '3':
        // crudReadByMake('Model T')
        singleInput = document.getElementById("singleMethod")
        await createResponse(await crudReadByMake(singleInput.value))
        break
      case '4':
        singleInput = document.getElementById("singleMethod")
        await createResponse(await crudReadByModel(singleInput.value))
        // crudReadByModel('Ford')
        break
      case '5':
        //need to create a body
        singleInput = document.getElementById("singleMethod")
        const updateBody = {}
        await createResponse(await crudUpdate(singleInput.value, updateBody)
        // crudUpdate(8, updateData)
        break
      case '6':
        singleInput = document.getElementById("singleMethod")
        await createResponse(await crudDelete(singleInput.value))
        // crudDelete(8)
        break
      case '7':
        //need to create a body
        const createBody = {}
        await createResponse(await crudCreate(createBody)
        // crudCreate(createData)
    }
  } catch (error) {
    console.log(error)
  }
}




// crudCreate(createData)
// crudRead(9)
// crudReadByMake('Model T')
// crudReadByModel('Ford')
// crudReadByYear('1994')
// crudUpdate(8, updateData)
// crudDelete(8)


async function main() {
  try {
    createResponse(await crudReadByMake('Model T'))

    document.getElementById("submitRequest").addEventListener("click", submitRequest())
    document.getElementById("postMethod").addEventListener("click", methodChanged())
    document.getElementById("apiUrl").value = ' '
  } catch (error) {
    console.log(error)
  }

}

main()
