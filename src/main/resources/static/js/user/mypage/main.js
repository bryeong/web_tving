const historyViewUl = document.getElementById('history-view').getElementsByTagName('ul').item(0);

get_all_watch_program_list();

function get_all_watch_program_list(){
    console.log("가져오기")
    const request = new XMLHttpRequest();
    request.open('GET', '/user/mypage/main/watch');
    request.send();
    request.onload = () => {
        if(request.status === 200){
            create_view_data(JSON.parse(request.response));
        }
    }
}

function create_view_data(viewDatas) {
    historyViewUl.innerHTML = '';
    for (data of viewDatas) {
        historyViewUl.insertAdjacentHTML('beforeend', '<li>\n' +
            `          <img src="/images/program/${data.programName}/poster/${data.watchOrder}.webp" alt="">\n` +
            `          <div>${data.title} ${data.watchOrder}화</div>\n` +
            `          <div>${data.watchDate} 시청</div>\n` +
            '        </li>');
    }
}