function getQueryParam(param) {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get(param);
}

getTodos()

function getTodos() {
  let queryParam = getQueryParam(`userId`);
  let element = document.getElementById(`todos`)
  let s = "";
  axios({
    url: `http://localhost:8080/api/todo/filter?userId=${queryParam}`,
    method: "GET",
    headers: {
      "Authorization": localStorage.getItem("token")
    }
  }).then(res => {
    res.data.map(m=>{
      s+=`<tr>
<td>${m.id}</td>
<td>${m.user.name}</td>
<td>${m.title}</td>
<td>${m.completed}</td>
</tr>`
    })
    element.innerHTML = s
  })
}
