function getQueryParam(param) {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get(param);
}
getPosts()
function getPosts(){
  const userid = getQueryParam('userId')
  let post = document.getElementById('posts')
  let s = ""
  axios({
    url:`http://localhost:8080/api/post/filter?userid=${userid}`,
    method:'GET',
    headers:{
      "Authorization":localStorage.getItem("token")
    }
  }).then(res=>{
    res.data.map(r=>{
      s+=`<tr>
<td>${r.id}</td>
<td>${r.user.name}</td>
<td>${r.title}</td>
<td>${r.body}</td>
<td><button onclick="getComments(${r.id})" class="btn btn-dark">Comments
</button></td>
</tr>`
    })
    post.innerHTML = s;
  })
}

function getComments(postId){
  const url = `../html/comment.html?postId=${postId}`;
  window.location.href = url
}
