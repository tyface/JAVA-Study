/*
 * 우주선 객체에 대한 선언
 */
function Ship(parent,posX,posY,width,height){
	/* 우주선을 그리기 위한 속성값,
	 * 좌표(x위치,y위치)크기(너비,높이)
	 * 우주선이 그려 질 부모요소
	 * */
	this.parent = parent;
	this.posX = posX;
	this.posY = posY;
	this.width = width;
	this.height = height;
	//실제 우주선이 그려질 요소 변수
	this.span;
	this.img;

	//우주선이 움직이는 거리를 지정하는 변수
	this.stepX = 0; //나중에 화면에서 키보드가 눌렸을 때 왼쪽 오른쪽 키에 따라서 변경

	//초기화 함수 : 우주선 요소 생성, 생성 후 부모요소에 붙이기
	this.init = function(){
		this.span = $("<span></span>").width(this.width+"px")
		.height(this.height+"px");
		this.span.css({
			"position" : "absolute",
			"top"  :this.posY+"px",
			"left" :this.posX+"px"
		});



		this.img = $("<img>").attr("src","./img/ship.png")
		.width(this.width +"px").height(this.heigth+"px");

		//요소1.append(요소2); : 요소2를 요소1의 하위요소로 추가
		this.span.append(this.img);
		//만들어낸 span요소를 부모요소(content)에 붙이기
		this.parent.append(this.span);
	}
	//요소가 움직이는건 요소의 위치를 변경시키는 것 : 위치를 변경하는 함수
	this.move = function(){
		//특정 값 만큼만 이동
		var me = this;
		if(this.posX + this.stepX < 970 && this.posX + this.stepX > 10 ){
			this.posX = this.posX + this.stepX;

			this.span.css("left",this.posX+"px");
		}

		//한번 호출 되고 나면 stepX의 값에 따라서 계속해서 움직이도록 작성
		//>>>일정 뒤에 한 번  move() 호출
		setTimeout(function(){
			me.move();
		},10);
	}

}
