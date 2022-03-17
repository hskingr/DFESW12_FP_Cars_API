async function crudCreate(data) {
  try {
    const http = new simpleFETCH;
    const res = await http.post(`http://localhost:8080/createItem/`, data, headerOpts)

    return res
  } catch (error) {
    console.log(error)
    sendErr(error)
  }
}


async function crudRead(id) {
  try {
    const http = new simpleFETCH;
    const res = await http.get(`http://localhost:8080/readItem/${id}`, headerOpts)

    if (res.error != null) throw new error


    return res
  } catch (error) {
    sendErr(error)
  }
}

async function crudReadByYear(year) {
  try {
    const http = new simpleFETCH;

    const res = await http.get(`http://localhost:8080/findItemsByYear/${year}`, headerOpts)
    return res
  } catch (error) {
    console.log(error)
    sendErr(error)
  }
}

async function crudReadByModel(model) {
  try {
    const http = new simpleFETCH;
    const res = await http.get(`http://localhost:8080/findItemsByModel/${model}`, headerOpts)
    return res
  } catch (error) {
    console.log(error)
    sendErr(error)
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
    sendErr(error)
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
    sendErr(error)
  }
}

async function crudDelete(id) {
  try {
    const http = new simpleFETCH;

    const res = await http.delete(`http://localhost:8080/deleteItem/${id}`, headerOpts)
    console.log(`deleted ${res}`)
    return res
  } catch (error) {
    console.log(error)
    sendErr(error)
  }
}

async function sendErr(error) {
  const errorMess = `<div class="alert alert-primary d-flex align-items-center" id="alert" role="alert">
    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
      <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
    </svg>
    <div>
    ${error.error}
      No Results Found
    </div>
  </div>`
    document.getElementById('cards').insertAdjacentHTML("afterbegin", errorMess)
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
    document.getElementById('cards').innerHTML = ''
    console.log(document.getElementById('alert'))
    if (document.getElementById('alert') != null) {
      console.log('hey')
      document.getElementById('alert').removeChild()
    }
    switch (x) {
      case "post":
        select = document.getElementById("apiUrl")
        select.innerHTML = ''
        const option7 = document.createElement('option')
        option7.value = 7
        option7.innerHTML = `http://localhost:8080/createItem/ `
        select.appendChild(option7)
        // document.getElementById("apiUrl").value = `http://localhost/`
        const toHide = document.getElementsByClassName('firstRowInput')
        document.getElementsByClassName('firstRowInput')[0].classList.add('d-none')
        document.getElementsByClassName('firstRowInput')[1].classList.add('d-none')
        document.getElementById('forPostDelete').classList.remove('d-none')
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
        document.getElementById('firstRowInput').innerHTML = 'id'
        document.getElementsByClassName('firstRowInput')[0].classList.remove('d-none')
        document.getElementsByClassName('firstRowInput')[1].classList.remove('d-none')
        document.getElementById('forPostDelete').classList.add('d-none')
        break
      case "put":
        select = document.getElementById("apiUrl")
        select.innerHTML = ''
        console.log(x)
        const option5 = document.createElement('option')
        option5.value = 5
        option5.innerHTML = `http://localhost:8080/updateItem/ `
        select.appendChild(option5)
        document.getElementsByClassName('firstRowInput')[0].classList.remove('d-none')
        document.getElementsByClassName('firstRowInput')[1].classList.remove('d-none')
        document.getElementById('forPostDelete').classList.remove('d-none')
        break
      case "delete":
        select = document.getElementById("apiUrl")
        select.innerHTML = ''
        const option6 = document.createElement('option')
        option6.value = 6
        option6.innerHTML = `http://localhost:8080/deleteItem/ `
        console.log(x)
        select.appendChild(option6)
        document.getElementsByClassName('firstRowInput')[0].classList.remove('d-none')
        document.getElementsByClassName('firstRowInput')[1].classList.remove('d-none')
        document.getElementById('forPostDelete').classList.add('d-none')
    }
  } catch (error) {
    console.log(error)
  }

}

async function createResponse(resData) {
  try {
    console.log(resData)

    if (resData.length > 0 || resData != null) {
      if (!resData.length != null) {
        resData = [resData]
      }
      resData.forEach(item => {
        const card = document.createElement('div')
        card.className = 'card animate__animated animate__fadeInDown'
        card.style = 'width: 18rem'
        card.style.setProperty('--animate-duration', '0.5s');
        card.style.setProperty('--animate-delay', '0.5s');

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

        card.addEventListener('animationend', () => {
        console.log('hey')
        });
      })
    }
  } catch (error) {
    const errorMess = `<div class="alert alert-primary d-flex align-items-center" role="alert">
    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
      <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
    </svg>
    <div>
    ${error.error}
      No Results Found
    </div>
  </div>`
    document.getElementById('cards').insertAdjacentHTML("afterbegin", errorMess)
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
        const updateData = {
          year: document.getElementById("inputYear").value,
          model:document.getElementById("inputModel").value,
          make: document.getElementById("inputMake").value
        }
        await createResponse(await crudUpdate(singleInput.value, updateData))


        // crudUpdate(8, updateData)
        break
      case '6':
        singleInput = document.getElementById("singleMethod")
        await (await crudDelete(singleInput.value))
        // crudDelete(8)
        break
      case '7':
        //need to create a body


                const createData = {
                  year: document.getElementById("inputYear").value,
                  model: document.getElementById("inputModel").value,
                  make: document.getElementById("inputMake").value
                }
                console.log(createData)
        await createResponse(await crudCreate(createData))

        // crudCreate(createData)
        break
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
    // createResponse(await crudReadByYear('1994'))
    document.getElementById("submitRequesty").addEventListener("click", submitRequest())
    document.getElementById("postMethody").addEventListener("click", methodChanged())
    document.getElementById("apiUrl").value = ' '
  } catch (error) {
    console.log(error)
  }

}

main()
