function prepareRequest() {

    let ownerId = document.getElementById('ownerId').value;
    let hash = document.getElementById('hash').value;
    let description = document.getElementById('description').value;

    let url = "http://localhost:8080/blazon.html?"
    url += 'ownerId=' + (ownerId == '' ? 0 : ownerId) + '&';
    url += 'hash=' + hash + '&';
    url += 'description=' + description +'&';
    url += 'size=10&page=0'

    return  {
        url: url,
        method: "GET"
    }
}

function redirect() {
    document.location = prepareRequest().url;
}