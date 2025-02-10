var Elem = function(value, min){
        this.value = value;
        this.min = min;
}
/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.first = null;
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
       if (!this.first){
            this.first = new Elem(x, x);
        }else{
            let e = new Elem(x, Math.min(x,this.first.min));
            e.next = this.first;
            this.first = e;
        }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
        if(!this.first)
            return;
        // let temp = this.first.next;
        // this.first.next = null;
        // this.first = temp;
    this.first = this.first.next;
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
        if(!this.first)
            return -1;
        return this.first.value;
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
        if(!this.first)
            return -1;
        return this.first.min;
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */