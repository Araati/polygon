async function getJson(url) {
    let response = await fetch(url);
    if (response.ok) {
        return(await response.json());
    } else {
        alert("Ошибка HTTP: " + response.status);
    }
}

function searchByOwnerIdOrHash()   {
    let a = document.getElementById('ownerId');
    let b = document.getElementById('hash');
    if(a.value != "")
        getJson("http://localhost:8080/blazonByOwner?ownerId=" + document.getElementById("ownerId").value).then(c => document.location = "blazon.html?" + c.id);
    else if(b.value != "")
        getJson("http://localhost:8080/blazonByHash?hash=" + document.getElementById("hash").value).then(c => document.location = "blazon.html?" + c.id);
    else
        document.location = "blazon.html";
}

function searchByDescription()  {
    getJson("http://localhost:8080/blazonByDescription?description=" + document.getElementById("description").value).then(function (result) {
        let url = "blazon.html";
        console.log(result);
        for(let i = 0; result.length > i; i++)  {
            url += "?" + result[i].id;
        }
        document.location = url;
    });
}