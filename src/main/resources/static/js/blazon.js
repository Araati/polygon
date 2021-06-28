function createBlazonView(blazon) {
    let x = document.getElementById('pageMain');
    x.insertAdjacentHTML("beforeend",
        `
    <div class="container mt-5 mb-5">
        <div class="alert alert-info mt-2">
            <h6><b>Image</b></h6>
            <img src="https://www.landsoflords.com/img/herald/FGOpFZuCpWF0bQ__.st.jpg" alt="">
            <h6><b>Description:</b></h6>
            <p>${blazon.description}</p>
            <h6><b>Hash:</b></h6>
            <p>${blazon.hash}</p>
            <h6><a href="http://localhost:8080/owners.html?${blazon.id}">Owners</a></h6>
        </div>
    </div>
`);
}

function preparePageRequest(nextPage, paginationEvent) {

    const currentURL = new URL(
        window.location.href
    );

    let ownerId = currentURL.searchParams.get('ownerId')
    let hash = currentURL.searchParams.get('hash')
    let description = currentURL.searchParams.get('description')
    let size = currentURL.searchParams.get('size')
    let page = currentURL.searchParams.get('page')
    let url;

    if (!paginationEvent || paginationEvent == undefined)    {
        url = "http://localhost:8080/criteria?"
    }   else {
        url = "http://localhost:8080/blazon.html?"
    }
    url += 'ownerId=' + (ownerId == '' ? 0 : ownerId) + '&';
    url += 'hash=' + hash + '&';
    url += 'description=' + description + '&';
    url += 'size=' + size + '&';
    if(nextPage == page || nextPage == undefined) {
        url += 'page=' + page;
    }   else    {
        url += 'page=' + nextPage;
    }

    return  {
        url: url,
        method: "GET"
    }
}

function paginationStart(totalPages, currentPage)   {

    let paginator = document.querySelector(".pagination");
    let page = "";

    if(currentPage != 0)    {
        page += `<li class="page-item"><a class="page-link" href="javascript:pagination(${currentPage}-1);">Previous</a></li>`
    } else  {
        page += `<li class="page-item disabled"><a class="page-link" href="javascript:pagination(${currentPage}-1);">Previous</a></li>`
    }

    if(currentPage != 0)    {
        page += `<li class="page-item"><a class="page-link" href="javascript:pagination(${currentPage-1});" id=${currentPage-1}>${currentPage}</a></li>`
    }

    let iterationMax = 2;
    if(currentPage == 0) iterationMax++;

    for (let i = 0; i < iterationMax; i++) {
        if(currentPage+i < totalPages) {
            if(currentPage+1 == currentPage+1+i)    {
                page += `<li class="page-item active"><a class="page-link" href="javascript:pagination(${currentPage+i});" id=${currentPage+i}>${currentPage+1+i}</a></li>`
            } else  {
                page += `<li class="page-item"><a class="page-link" href="javascript:pagination(${currentPage+i});" id=${currentPage+i}>${currentPage+1+i}</a></li>`
            }
        }
    }

    if(currentPage+1 != totalPages) {
        page += `<li class="page-item"><a class="page-link" href="javascript:pagination(${currentPage+1});">Next</a></li>`
    } else  {
        page += `<li class="page-item disabled"><a class="page-link" href="javascript:pagination(${currentPage+1});">Next</a></li>`
    }

    paginator.innerHTML = page;

}

function findBlazons() {

    const request = preparePageRequest();

    fetch(request.url, request)
        .then(resp => resp.json())
        .then(function (result) {
            console.log(result)
            for (let i = 0; i < result.content.length; i++) {
                createBlazonView(result.content[i]);
            }
            paginationStart(result.totalPages, result.number)
        });
}

function pagination(nextPage)   {

    document.location = preparePageRequest(nextPage, true).url;

}

findBlazons();