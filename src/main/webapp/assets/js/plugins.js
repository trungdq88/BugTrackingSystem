/**
 * Created by dinhquangtrung on 4/6/15.
 */

function generateLabel() {
    var bgColor = randomColor({format: 'rgbArray'});
    var textColor = (bgColor[0]*0.299 + bgColor[1]*0.587 + bgColor[2]*0.114) > 186? '#000000' : '#ffffff';
    return {
        bg: 'rgb(' + bgColor[0] + ',' + bgColor[1] + ',' + bgColor[2] + ')',
        text: textColor
    }
}