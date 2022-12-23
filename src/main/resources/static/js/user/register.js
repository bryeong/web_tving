const form = document.forms.namedItem('register-form');
const confirmBtn = document.getElementById('register-btn').getElementsByTagName('button');
confirmBtn.addEventListener('click', () => {
    form.action = '/user/register';
    form.method = 'post';
    form.submit();
});