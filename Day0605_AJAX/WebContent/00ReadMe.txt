Ajax
(Asynchronous Javascript and XML, 에이잭스)
특정 url로 요청을 보내서 데이터를 받아오기 위해서 사용
비동기 방식
jQuery에서 ajax 요청해서 데이터 받아오기
비동기 방식의 메서드
load() : 외부에 있는 컨텐츠를 가져올때 사용
	$(요소).load(url,data,콜백);
ajax() : http 프로토콜을 이용해서 요청을 전송할 수 있고
         데이터를 text,xml,json 형태로 받아 올 수 있음
$.ajax({옵션});
$.ajax({
	url:"전송url",
	type:"전송방식 get|post",
	data : "전송할 데이터",
	dataType : "요청데이터 타입(html|xml|json|text)"
	success : funtion(result){//요청이 제대로 전송되었을 때 실행하는 함수
		실행문;
	},
	error : function(){//요청이 실패 했을 때 실행되는 함수
		실행문;
	}
});
JSON (Javascript Object Nation)
: 자바 스크립트 객체 표기법 ,client와 서버간 정보를 교환하기 위해서 사용
{
	"key1" : value1,
	"key2" : value2
	"key3" : [{k:v},{k:v},{k:v}]
}

command pattern :




ajax에 많은 데이터 담아서 전송 및 처리 하기
