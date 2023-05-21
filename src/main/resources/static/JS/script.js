const textarea = document.querySelector('textarea')
const post= document.getElementById('post')
const span_character= document.getElementById('characters')
//-----------------TextArea POST-------
textarea.style.cssText = `height: ${textarea.scrollHeight}px; overflow-y: hidden`;
textarea.addEventListener('input', function () {
    this.style.height = "auto";
    this.style.height = `${this.scrollHeight}px`;
});
//-------------------
textarea.addEventListener('input',function() {
    
    if (textarea.value.length === 0) {
        post.setAttribute('disabled', 'true');
        post.classList.remove("o-100")
        span_character.classList.remove("o-100")
        post.classList.add("o-0");
        span_character.classList.add("o-0");
    } else {
        post.removeAttribute('disabled');
        post.classList.remove('o-0')
        span_character.classList.remove('o-0')
        post.classList.add("o-100")
        span_character.classList.add("o-100")
    }
});
//Mostrar caracteres disponibles
textarea.addEventListener('input',function(){
    let characters=255;
    let lastSize=0;
    console.log("LastSize=" + lastSize+" Textaere= "+textarea.textLength)
    span_character.textContent=characters=(lastSize-textarea.textLength)+characters;
    lastSize=textarea.textLength
});
//VALIDAR Y BLOQUEAR POST
function validateForm(){
    if(textarea.value.length>255 || textarea.value.length<=0){
        post.style.cssText = `animation: error 1s both`
        setTimeout(()=>{post.style.removeProperty('animation')},1000)
        return false;
    }else{
        return true;
    }
}
