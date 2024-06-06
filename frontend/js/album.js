const urlParams = new URLSearchParams(window.location.search)
 function getAlbums(){
  let userId = urlParams.get(`userId`);
  let s = "";
  let element = document.getElementById(`albums`);
  axios({
    url:`http://localhost:8080/api/album`
  })
}
