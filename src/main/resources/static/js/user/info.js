const [confirmBtn, cancelBtn] = [...document.getElementById('confirm-btns').getElementsByTagName('input')];
const infoForm = document.forms.namedItem('info-form');
const [inputEmail, inputTel] = infoForm.getElementsByTagName('input');

confirmBtn.addEventListener('click', e => {
    const [emailHost, emailDomain] = document.getElementById('email-input').getElementsByTagName('input');
    const phoneHead = document.getElementById('tel-input-select');
    const [telMiddle, telFoot] = document.getElementById('tel-input').getElementsByTagName('input');
    inputEmail.value = emailHost.value + '@' + emailDomain.value;
    inputTel.value = phoneHead.value + '-' + telMiddle.value + '-' + telFoot.value;

    infoForm.action = '/user/info';
    infoForm.method = 'post';
    infoForm.submit();
});

cancelBtn.addEventListener('click', e => {
    document.location.href = '/main';
});