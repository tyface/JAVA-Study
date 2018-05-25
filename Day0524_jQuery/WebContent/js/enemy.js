/*
 * 우주선 객체에 대한 선언
 */
function Enemy(parent,posX,posY,width,height,src,hp){

	this.parent = parent;
	this.posX = posX;
	this.posY = posY;
	this.width = width;
	this.height = height;
	this.src= src;
	this.hp = hp;
	//실제 우주선이 그려질 요소 변수
	this.span;
	this.img;


	this.init = function(){
		this.span = $("<span></span>").width(this.width+"px")
		.height(this.height+"px");
		this.span.css({
			"position" : "absolute",
			"top"  :this.posY+"px",
			"left" :this.posX+"px"
		});



		this.img = $("<img>").attr("src",this.src)
		.width(this.width +"px").height(this.heigth+"px");

		//요소1.append(요소2); : 요소2를 요소1의 하위요소로 추가
		this.span.append(this.img);
		//만들어낸 span요소를 부모요소(content)에 붙이기
		this.parent.append(this.span);
	}

}
