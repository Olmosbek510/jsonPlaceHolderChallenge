const BASE_URL = "http://localhost:8080"
getUsers()

function getUsers() {
  let s = "";
  axios({
    url: BASE_URL + '/api/user',
    method: 'GET',
    headers: {
      "Authorization": localStorage.getItem("token")
    }
  }).then(res => {
    let table = document.getElementById(`users`);
    let s = "";
    console.log(res.data);
    res.data.map(m => {
      s += `<tr>
<td>${m.id}</td>
<td>${m.name}</td>
<td>${m.username}</td>
<td>${m.email}</td>
<td>${m.phone}</td>
<td>${m.website}</td>
<td>${m.company.name}</td>
<td>
        <button onclick="showPosts(${m.id})">Posts</button>
        <button onclick="showTodos(${m.id})">Todos</button>
        <button onclick="showAlbums(${m.id})">Albums</button>
      </td>
</tr>`
      table.innerHTML = s;
    })
  })
}

function showPosts(userId) {
  window.location.href = `../html/post.html?userId=${userId}`
}

function showTodos(userId) {
  window.location.href = `../html/todo.html?userId=${userId}`
}

function showAlbums(userId) {
  window.location.href = `../html/album.html?userId=${userId}`
}
