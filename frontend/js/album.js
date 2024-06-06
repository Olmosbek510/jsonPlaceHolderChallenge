const urlParams = new URLSearchParams(window.location.search)
getAlbums()
function getAlbums() {
  let userId = urlParams.get(`userId`);
  let s = "";
  let element = document.getElementById(`albums`);
  console.log(userId)
  axios({
    url: `http://localhost:8080/api/album/filter?userId=${userId}`,
    method: "GET",
    headers: {
      "Authorization": localStorage.getItem("token")
    }
  }).then(res => {
    res.data.map(r => {
      s += `<tr>
<td>${r.id}</td>
<td>${r.user.name}</td>
<td>${r.title}</td>
<td><button class="btn btn-dark" onclick="showPhotos(${r.id})">Photos</button></td>
</tr>`
    })
    element.innerHTML = s;
  })
}
function showPhotos(albumId) {
  window.location.href = `../html/photo.html?albumId=${albumId}`
}
