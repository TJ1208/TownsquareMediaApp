const url = "https://api.cloudinary.com/dwzhlnnwa/image/upload/townsquare/c_crop,g_custom";
const form = document.getElementById("imageuploadform");
let globalId = '';
let globalSrc = '';
console.log("In the 'cloudinary-upload.js' script");

function uploadImage() {

  console.log("got js");
  const files = document.querySelector("[type=file]").files;
  const formData = new FormData();

  for (let f of files) {
    let file = f;
    formData.append("file", file);
    formData.append("ml_default", "ml_default");

    fetch(url, {
      method: "POST",
      body: formData
    })
      .then((response) => {
        return response.text();
      })
      .then((data) => {
        document.getElementById("data").innerHTML += data;
      });
  }
}



let myWidget = cloudinary.createUploadWidget({
  cloudName: 'dwzhlnnwa',
  uploadPreset: 'zgc6dhw7',
  folder: "townsquare",
  cropping: true,
  multiple: false,
  styles: {
    palette: {
      window: "#FFF",
      windowBorder: "#0274d87b",
      tabIcon: "#5bc0de",
      menuIcons: "#5A616A",
      textDark: "#000000",
      textLight: "#FFFFFF",
      link: "#0275d8",
      action: "#FF620C",
      inactiveTabIcon: "#0E2F5A",
      error: "#F44235",
      inProgress: "#0078FF",
      complete: "#20B832",
      sourceBg: "#E4EBF1"
    },
    frame: {
      background: "#0E2F5B99"
    }
  }
}, (error, result) => {
  if (!error && result && result.event === "success") {
    console.log('Done! Here is the image info: ', result.info);
    document.getElementById(globalId).select();
    document.getElementById(globalId).value = result.info.url;
    // document.getElementById(globalId).value;
    if (globalSrc) {
      document.getElementById(globalSrc).src = result.info.url;
    }
    // document.getElementById(globalSrc).hidden = false;
    // document.getElementById("upload_widget").textContent = "Change Image";
    // console.log("Image URL is " + result.info.url);
  }
}
)

function openWidget(id, src) {
  globalId = id;
  globalSrc = src;
  myWidget.open();
}