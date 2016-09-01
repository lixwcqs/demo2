/**
 * Created by li on 2015/11/29.
 */
function percentage(numerator , denominator) {
    //小数点后两位百分比
    return (Math.round(numerator / denominator * 10000) / 100.00 + "%");
}