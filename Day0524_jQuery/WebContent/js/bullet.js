function hitTest(me,target){
	//me: 총알 , target :적

	//me와 target은 dom객체
	//dom 객체에서 style 속성을 가져오기 위해서 window.getComputeStyle();
	//style 속성을 가지고 있는 객체를 하나 반환
	var meStyle = window.getComputedStyle(me);
	var targetStyle = window.getComputedStyle(target);

	var me_x = parseInt(meStyle.left); //parsetInt ("12px") >> 12
	var me_y = parseInt(meStyle.top);
	var me_width = parseInt(meStyle.width);
	var me_height = parseInt(meStyle.height);

	var target_x = parseInt(targetStyle.left);
	var target_y = parseInt(targetStyle.top);
	var target_width = parseInt(targetStyle.width);
	var target_height = parseInt(targetStyle.height);
	/*************************************************/
	//충돌 판단 1-1 가로범위 판단
	//내 x좌표가 타겟의 x range에 있는지 판단
	var result1 = (me_x >= target_x) && (me_x <= target_x + target_width);
	//내 가로 폭이 타겟의 가로폭내에 있는지 판단
	var result2 = (me_x + me_width >= target_x)
			&& (me_x + me_width <= target_x + target_width);

	//충돌 판단 1-2 세로범위 판단
	//세로 범위 겹침
	var result3 = (me_y >= target_y) && (me_y <= (target_y + target_height));
	var result4 = (me_y + me_height >= target_y)
			&& (me_y + me_height <= (target_y + target_height));

	//총알과 target의 영역이 겹치는지 확인하고...
	//겹치면 true 아니면 false;
	//me 와 target의 속성값을 비교 left, top, width, height

	var result = (result1 || result2) && (result3 || result4);

	return result;
	//총알의 영역과 target의 영역이 겹치면 맞았다라고 판단
}
/*
 * 우주선 객체에 대한 선언
 */
function Bullet(parent,posX,posY,width,height,enemies){
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
	this.enemies = enemies;


	//총알이 움직이는 거리를 지정하는 변수
	this.speed = -10;

	//초기화 함수 : 우주선 요소 생성, 생성 후 부모요소에 붙이기
	this.init = function(){
		this.span = $("<span></span>").width(this.width+"px")
		.height(this.height+"px");
		this.span.css({
			"position" : "absolute",
			"top"  :this.posY+"px",
			"left" :this.posX+"px"
		});

		this.img = $("<img>").attr("src","./img/bullet.png")
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
		this.posY = this.posY + this.speed;

		this.span.css("top",this.posY+"px");

		//총알이 밖으로 나가면 없애주기
		if(this.posY < 0){
			this.span.remove(); //현재 요소 삭제
			return;
		}

		//움직이면서 적에 맞았는지 판단!!>>적의 위치정보를 알고 있어야함
		//모든적의 위치를 총알의 위치와  한번씩 비교 하면서 맞았는지 판단
		for(var i=0;i<enemies.length;i++){
			var result = hitTest(me.span[0],this.enemies[i].span[0]);

			if(result){
				//맞았음 : 총알 삭제, 적 피 -1
				this.span.remove();
				this.enemies[i].hp += -1;

				if(this.enemies[i].hp == 0){
					this.enemies[i].span.remove();
					//적 목록에서 적삭제
					enemies.splice(i,1);
				}
				return;
			}
		}
		//한번 호출 되고 나면 stepX의 값에 따라서 계속해서 움직이도록 작성
		//>>>일정 뒤에 한 번  move() 호출
		setTimeout(function(){
			me.move();
		},10);
	}

}
