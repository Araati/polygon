function createOwnerView(ownerId, ownerPrefix) {
    document.body.insertAdjacentHTML("afterbegin",
        `<div class="container mt-5 mb-5">
        <div class="alert alert-info mt-2">
            <h6><b>OwnerPrefix + OwnerId:</b></h6>
            <p>`+ ownerPrefix + ownerId +`</p>
        </div>
    </div>`);
}

function getOwners()    {

    const currentURL = new URL(
        window.location.href
    );

    let blazonId = currentURL.searchParams.get('blazonId')

    fetch("http://localhost:8080/blazon/" + blazonId + "/owners")
        .then(resp => resp.json())
        .then(function (result) {
            for (let i = 0; i < result.length; i++) {
                createOwnerView(result[i].ownerId, result[i].ownerPrefix);
                if(i == 10)
                    break;
            }
        });
}

getOwners();