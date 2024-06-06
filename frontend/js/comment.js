function getQueryParam(param) {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get(param);
}

getComments()
function getComments() {
  let queryParam = getQueryParam(`postId`);
  console.log(queryParam)
  axios({
    url: `http://localhost:8080/api/comment/filter?postId=${queryParam}`,
    method: "GET",
    headers: {
      "Authorization": localStorage.getItem("token")
    }
  }).then(res => {
    let s = "";
    let element = document.getElementById(`comments-table`);
    res.data.map(m => {
      s += `<tr>
<td>${m.id}</td>
<td>${m.post.title}</td>
<td>${m.name}</td>
<td>${m.email}</td>
<td>${m.body}</td>
</tr>`
    })
    element.innerHTML = s;
  })
}

