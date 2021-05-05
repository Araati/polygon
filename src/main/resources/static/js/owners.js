async function getJson(url) {
    let response = await fetch(url); //'http://localhost:8080/blazon/15'
    console.log(response);
    if (response.ok) {
        return(await response.json());
    } else {
        alert("Ошибка HTTP: " + response.status);
    }
}

function getBlazonId() {
    let what = decodeURIComponent(location.search.substr(1)).split('&');
    what.splice(0, 1);
    let result = what[0];
    console.log(result);
    return result;
}

function createOwnerView(ownerId, ownerPrefix) {

    document.body.insertAdjacentHTML("afterbegin",
`<div class="container mt-5 mb-5">
        <div class="alert alert-info mt-2">
            <h6><b>OwnerId:</b></h6>
            <p>`+ ownerId +`</p>
            <h6><b>OwnerPrefix:</b></h6>
            <p>`+ ownerPrefix +`</p>
        </div>
    </div>`);
}

let i = 0;
do {
    if(i == 0) {
        getJson("http://localhost:8080/blazon/" + getBlazonId() + "/owners")
            .then(obj => i = obj.length);
    }
    getJson("http://localhost:8080/blazon/" + getBlazonId() + "/owners")
        .then(obj => createOwnerView(obj[i].ownerId, obj[i].ownerPrefix));
    i--;
    console.log(i);
} while(i != 0);

/*getJson("http://localhost:8080/blazon/" + getBlazonId() + "/owners")
    .then(obj => createOwnerView(obj[0].ownerId, obj[0].ownerPrefix));*/
