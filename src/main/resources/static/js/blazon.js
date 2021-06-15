async function getJson(url) {
    let response = await fetch(url); //'http://localhost:8080/blazon/15'
    if (response.ok) {
        return(await response.json());
    } else {
        alert("Ошибка HTTP: " + response.status);
    }
}

function getBlazonId() {
    let what = decodeURIComponent(location.search.substr(1)).split('?');
    return what;
}

function createBlazonView(description, hash, id) {

    document.body.insertAdjacentHTML("afterbegin",
        `<div class="container mt-5 mb-5">
        <div class="alert alert-info mt-2">
            <h6><b>Image</b></h6>
            <h6><b>Description:</b></h6>
            <p>`+ description +`</p>
            <h6><b>Hash:</b></h6>
            <p>`+ hash +`</p>
            <h6><a href="http://localhost:8080/owners.html?`+ id +`">Owners</a></h6>
        </div>
    </div>`);
}
if(getBlazonId()[0] == "") {
    getJson("http://localhost:8080/blazon").then(function (result) {
        for (let i = 0; i < result.length; i++) {
            createBlazonView(result[i].description, result[i].hash, result[i].id);
        }
    });
        }   else
    {
        for (let i = 0; i < getBlazonId().length; i++) {
            getJson("http://localhost:8080/blazon/" + getBlazonId()[i]).then(function (result){
                createBlazonView(result.description, result.hash, result.id);
            });
        }
    }