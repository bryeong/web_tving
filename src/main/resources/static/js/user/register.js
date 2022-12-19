const form = document.forms.namedItem('register-form');
const [backBtn, confirmBtn] = [...document.getElementById('register-buttons').getElementsByTagName('input')];
confirmBtn.addEventListener('click', () => {
    form.action = '/user/register';
    form.method = 'post';
    form.submit();
});

backBtn.addEventListener('click', () => {
    form.action = '/login';
    form.method = 'get';
    form.submit();
})