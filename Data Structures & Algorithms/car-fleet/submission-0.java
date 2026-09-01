class Solution {
    public class Car implements Comparable<Car> {
        int position;
        int speed;
        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
        @Override
            public int compareTo(Car other) {
    return Integer.compare(other.position, this.position);
}

    }
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for(int i=0;i<position.length;i++){
            cars[i] = new Car(position[i],speed[i]);
        }
        Arrays.sort(cars);

        Stack<Double> stack = new Stack<>();
        for(Car car: cars){
            stack.push((double)(target-car.position)/car.speed );
            if(stack.size()>=2){
                double before = stack.pop();
                double ahead = stack.pop();

                if(before<=ahead ){
                    stack.push(ahead);
                } else {
                    stack.push(ahead);
                    stack.push(before);
                }
            }
        }
        return stack.size();
        
    }
}
