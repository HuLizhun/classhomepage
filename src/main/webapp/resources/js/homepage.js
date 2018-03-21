/**
 * 设置head代码
 * @returns
 */
function getHead() {
    $(".head").html('<a href="/Textile083/login.action"><img src="/resources/images/logo.gif" width="100%" height="100%" /> </a>\n\
    		<span style="position: absolute; top: 20px; left: 450px;color:white;font-size:43px;font-family:Microsoft YaHei;">天津工业大学纺织083</span>\n\
    		<a href="http://www.tjpu.edu.cn/" target="_blank" style="position: absolute; top: 290px; left: 85.8%;color:white;font-size:18px;">工大主页</a>\n\
    		<span style="position: absolute; top: 290px; left: 92.2%;color:white;font-size:18px;">|</span>\n\
    		<a href="/Textile083/skip.action?name=contact" target="_blank" style="position: absolute; top: 290px; left: 93.3%;color:white;font-size:18px;">联系我们</a>');
}

/**
 * 设置search代码
 * @returns
 */
function getSearch() {
	    $(".search").html('<form action="/Textile083/search.action">\n\
	    		<table width="180" border="0" cellpadding="0" cellspacing="0">\n\
	    		<tr>\n\
	    		<td width="16"><img src="/resources/images/search_left.png" width="16" height="26" /></td>\n\
	    		<td bgcolor="#EEEEEE"><input type=hidden /><input name="context" type="text" id="context" size="15" value="请输入文章标题..." /></td>\n\
	    		<td width="67"><input type="image" src="/resources/images/search_right.png" /></td>\n\
	    		</tr>\n\
	    		</table>\n\
	    		</form>\n\
	    		<div>\n\
	    		<form action="/Textile083/search.action" style="left: 185px;top: 2px;position: absolute;">\n\
	    		<input type="submit" name="exit" id="exit" value="退出"/>\n\
	    		</form>\n\
	    		</div>');
}

/**
 * 设置navigation代码
 * @returns
 */
function getNavigation() {
	    $(".navigation").html('<ul>\n\
	    		<li><a href="/Textile083/login.action" target="_blank" class="white">班级主页</a></li>\n\
	    		<li><a href="/Textile083/skip.action?name=introduce" target="_blank" class="white">班级简介</a></li>\n\
	    		<li><a href="/Textile083/liberature.action" target="_blank" class="white">班级文学</a></li>\n\
	    		<li><a href="/Textile083/skip.action?name=photo" target="_blank" class="white">班级相册</a></li>\n\
	    		</ul>');
}

/**
 * 设置foot代码
 * @returns
 */
function getFoot() {
	    $(".foot").html('<a href="http://www.tjpu.edu.cn/" target="_blank" style="font-weight:normal;">天津工业大学&nbsp;&nbsp;&nbsp;&nbsp;</a> \n\
	    		<a href="http://fz.tjpu.edu.cn/" target="_blank" style="font-weight:normal;">纺织学院&nbsp;&nbsp;&nbsp;&nbsp;</a> \n\
	    		<a href="http://www.chinayarn.com/" target="_blank" style="font-weight:normal;">中国纱线网&nbsp;&nbsp;&nbsp;&nbsp;</a>\n\
	    		<a href="http://membrane.tjpu.edu.cn/" target="_blank" style="font-weight:normal;">天津工业大学分离膜与膜过程国家重点实验室&nbsp;&nbsp;&nbsp;&nbsp;</a><br>\n\
	    		<img src="/resources/images/foot.gif" width="100%" />');
}

/**
 * 设置update代码
 * @returns
 */
function getUpdate() {
	    $(".update").html('<a>最近更新 </a>\n\
	    		<div>\n\
	    		<table>\n\
	    		<tr>\n\
	    		<td>班级计划清明节去故宫</td>\n\
	    		<td>2009.4.1</td>\n\
	    		</tr>\n\
	    		<tr>\n\
	    		<td>开展娱乐活动杀人游戏</td>\n\
	    		<td>2009.4.1</td>\n\
	    		</tr>\n\
	    		<tr>\n\
	    		<td style=" width:500px;">我班近期将与纺织082班举行篮球赛</td>\n\
	    		<td>2009.4.1</td>\n\
	    		</tr>\n\
	    		<tr>\n\
	    		<td>我班党性知识竞赛进入决赛</td>\n\
	    		<td>2009.4.2</td>\n\
	    		</tr>\n\
	    		</table>\n\
	    		</div>');
}

/**
 * 设置photo代码
 * @returns
 */
function getPhoto() {
	    $(".photo").html('<a href="/Textile083/skip.action?name=photo" target="_blank" title="点击进入班级照片">班级照片</a>\n\
	    		<a href="/Textile083/skip.action?name=video" target="_blank" title="点击进入电子相册">电子相册</a> <br> <br> \n\
	    		<a href="/Textile083/skip.action?name=photo&num=64" target="_blank"><img src="resources/images/64.jpg" width="260px" height="170px" /> </a> <br> <br>\n\
	    		<a href="/Textile083/skip.action?name=photo&num=68" target="_blank"><img src="resources/images/68.jpg" width="260px" height="170px" /> </a><br>');
}

/**
 * 设置introduce代码
 * @returns
 */
function getIntroduce() {
	    $(".introduce").html('<a href="/Textile083/skip.action?name=introduce" target="_blank" title="点击进入班级简介">班级简介</a><br>\n\
	    		<p>纺织083班由27名同学组成，班主任夏川，带班党员张烨、张博。</p>\n\
	    		<p>我们班是一个相亲相爱大家庭，同学们团结向上，和谐相处。 班里的班委是一支具有凝聚力、亲和力的队伍，深得同学们的喜欢。他们做事雷厉风行，分工合作，即能各自发挥自己的长处，又能很愉快的一起共事。在班委的组织下，班里举行了很多活动，有趣味篮球赛、羽毛球赛、象棋赛等。我们班还组织共去周邓纪念馆、爬山等户外活动。这些活动即丰富了同学们的业余生活，又促进同学们的感情。</p>\n\
	    		<p>083班是一个人才辈出的班级，班里同学积极参加各种比赛，并且取得了优异的成绩。连经通担任了手语社副社长，在“主持人大赛”中，杨磊同学被评为 “最佳男主持”。在演讲大赛中，崔凤娇同学获得第二名的好成绩。在党性知识大赛中，我们的三名同学又成功进入了总决赛！在丛多的比赛中，总活跃着我们的身影 。</p>');
}

/**
 * 设置class_introduce代码
 * @returns
 */
function getClassIntroduce() {
	    $(".class_introduce1").html('<h1>相亲相爱大家庭</h1>\n\
	    		<p style="font-size:20px;">纺织083班由27名同学组成，班主任夏川，带班党员张烨、张博。</p>\n\
	    		<p style="font-size:20px;">我们班是一个相亲相爱大家庭，同学们团结向上，和谐相处。 班里的班委是一支具有凝聚力、亲和力的队伍，深得同学们的喜欢。他们做事雷厉风行，分工合作，即能各自发挥自己的长处，又能很愉快的一起共事。在班委的组织下，班里举行了很多活动，有趣味篮球赛、羽毛球赛、象棋赛等。我们班还组织共去周邓纪念馆、爬山等户外活动。这些活动即丰富了同学们的业余生活，又促进同学们的感情。</p>\n\
	    		<p style="font-size:20px;">083班是一个人才辈出的班级，班里同学积极参加各种比赛，并且取得了优异的成绩。连经通担任了手语社副社长，在“主持人大赛”中，杨磊同学被评为 “最佳男主持”。在演讲大赛中，崔凤娇同学获得第二名的好成绩。在党性知识大赛中，我们的三名同学又成功进入了总决赛！在丛多的比赛中，总活跃着我们的身影 。</p>\n\
	    		<p style="font-size:20px;">以下是班级所有成员信息：</p>');
}