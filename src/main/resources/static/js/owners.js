//todo: Legacy код, переписать всё

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

getJson("http://localhost:8080/blazon/" + getBlazonId()[0] + "/owners").then(function (result){;
    for(let i = 0; i < result.length; i++)    {
        createOwnerView(result[i].ownerId, result[i].ownerPrefix);
    }
})
