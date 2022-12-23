//프로그램 시청 버튼 (1화 혹은 이어보기) - 메인버튼
const watchBtn = document.getElementById('program-watch-button');
//프로그램 해당 회차 눌러서 보는 버튼
const watchOrderBtns = [...document.getElementsByClassName('program-watch-button')];
const programName = document.getElementById('program-title').getAttribute('name');

//버튼 눌렀을 시 동작
watchBtn.onclick = () => {
    const watchOrder = watchBtn.getElementsByTagName('span').item(0).getAttribute('name');
    program_watch_btn_clicked(watchOrder);
};

watchOrderBtns.forEach( btn => {
    btn.onclick = () => program_watch_btn_clicked(btn.getAttribute('name'))
});

function program_watch_btn_clicked(order){
    location.href = `/main/program/watch/${programName}/${order}`;
}