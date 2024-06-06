const urlParams = new URLSearchParams(window.location.search)
getPhotos()
let element = document.getElementById("photos");
function getPhotos(){
  let albumId = urlParams.get("albumId");
  axios({
    url:`http://localhost:8080/api/photo/filter?albumId=${albumId}`,
    method:"GET",
    headers:{
      "Authorization":localStorage.getItem("token")
    }
  }).then(res=>{
    let s = "";
    res.data.map(p=>{
      s+=`<tr>
    <td>${p.id}</td>
    <td>${p.album.title}</td>
    <td>${p.title}</td>
    <td><a href="${p.url}">${p.url}</a></td>
    <td><a href="${p.thumbnailUrl}">${p.thumbnailUrl}</a></td>
</tr>`
    })
    element.innerHTML = s
  })
}
