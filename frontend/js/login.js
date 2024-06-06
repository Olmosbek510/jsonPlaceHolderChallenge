const BASE_URL = "http://localhost:8080"
let form = document.getElementById(`loginForm`);
form.addEventListener("submit",handleSubmit)

function handleSubmit(){
  event.preventDefault();
  let username = event.target[0].value;
  let password = event.target[1].value;
  let obj = {
    "username": username,
    "password": password
  }
  axios({
    url: BASE_URL + "/api/auth/login",
    method: "post",
    data: obj
  }).then(res => {
    localStorage.setItem("token", res.data.accessToken)
    localStorage.setItem("refreshToken", res.data.refreshToken)
    window.location.href = "../html/admin.html"
  })
}
