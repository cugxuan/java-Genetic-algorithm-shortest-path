// 实现鼠标点击的js动画
'use strict';
var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) {if (window.CP.shouldStopExecution(2)){break;} var source = arguments[i]; for (var key in source) {if (window.CP.shouldStopExecution(1)){break;} if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } }
window.CP.exitedLoop(1);
 }
window.CP.exitedLoop(2);
 return target; };
 
var OPTS = {
    fill: 'none',
    radius: 25,
    strokeWidth: { 50: 0 },
    scale: { 0: 1 },
    angle: { 'rand(-35, -70)': 0 },
    duration: 500,
    left: 0,
    top: 0,
    easing: 'cubic.out'
};

var circle1 = new mojs.Shape(_extends({}, OPTS, {
    stroke: '#FF8966'
}));
var circle2 = new mojs.Shape(_extends({}, OPTS, {
    radius: { 0: 15 },
    strokeWidth: { 30: 0 },
    stroke: '#E5446D',
    delay: 'rand(75, 150)'
}));
