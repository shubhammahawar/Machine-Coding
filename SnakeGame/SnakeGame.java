// "static void main" must be defined in a public class.

/*

The LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked List across all elements
LinkedHashSet allow us to iterate through the elements in the order in which they were inserted.
When cycling through LinkedHashSet using an iterator, the elements will be returned in the order in which they were inserted.
*/


import java.util.*;
public class Main {
    
    public static class Snake {
        
        class Pair{
            int x;
            int y;
            Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
            
            @Override
            public boolean equals(Object o){
                if(this==o)
                    return true;
                if(o==null || getClass()!=o.getClass())
                    return false;
                Pair pair = (Pair)o;
                return (x==pair.x && y==pair.y);
            }
            
            @Override
            public int hashCode(){
                return Objects.hash(x,y);
            }
            
            
            
            
        }
        
        int x;
        int y;
        int width;
        int height;
        LinkedHashSet<Pair>snake;
        LinkedHashSet<Pair>food;
        
        public Snake(int width, int height, int [][]foods ){
            this.height = height;
            this.width = width;
            this.snake = new LinkedHashSet<>();
            this.food = new LinkedHashSet<>();
            for(int i=0;i<foods.length;i++)
                this.food.add(new Pair(foods[i][0], foods[i][1]));
            snake.add(new Pair(0,0));
            this.x=0;
            this.y=0;
            
        }
        
        boolean validateMove(int x, int y){
            if(snake.contains(new Pair(x,y)))
                return true;
            
            if(x<0 || x>=width)
                return true;
            if(y<0 || y>=height)
                return true;
            
            return false;
        }
        
        void changeSnakeSize(int x, int y){
            Pair p = food.stream().findFirst().get();
            if(p.equals(new Pair(x,y))){
                snake.add(new Pair(x,y));
                food.remove(p);
            }
            else{
                snake.add(new Pair(x,y));
                Pair s = snake.stream().findFirst().get();
                snake.remove(s);
                
            }
        }
        
        
        public int move(Character ch){
            if(ch.equals('U')){
                if(validateMove(x-1,y)){
                    return -1;
                }
                x--;
                changeSnakeSize(x,y);
            }
            else if(ch.equals('D')){
                if(validateMove(x+1,y))
                    return -1;
                x++;
                changeSnakeSize(x,y);
            }
            else if(ch.equals('L')){
                if(validateMove(x,y-1))
                    return -1;
                y--;
                changeSnakeSize(x,y);
            }
            else if(ch.equals('R')){
                if(validateMove(x,y+1))
                    return -1;
                y++;
                changeSnakeSize(x,y);
            }
            else{
                System.out.println("Invalid Move");
            }
            return snake.size()-1;
        } 
        
        
    }
    public static void main(String[] args) {
        Snake snake = new Snake (2,3,new int[][]{{1,2},{0,1}});
        System.out.println(snake.move('R')); //-> Returns 0
        System.out.println(snake.move('D')); //-> Returns 0
        System.out.println(snake.move('R')); //-> Returns 1
        System.out.println(snake.move('U')); //-> Returns 1
        System.out.println(snake.move('L')); //-> Returns 2
        System.out.println(snake.move('U')); //-> Returns -1
    }
}


/*
Leetcode 353: Design Snake Game
Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
You are given a list of food’s positions in row-column order. When a snake eats the food, its length and the game’s score both increase by 1.
Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
Example:
Given width = 3, height = 2, and food = [[1,2],[0,1]].
Snake snake = new Snake(width, height, food);
Initially the snake appears at position (0,0) and the food at (1,2).
|S| | |
| | |F|
snake.move("R"); -> Returns 0
| |S| |
| | |F|
snake.move("D"); -> Returns 0
| | | |
| |S|F|
snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
| |F| |
| |S|S|
snake.move("U"); -> Returns 1
| |F|S|
| | |S|
snake.move("L"); -> Returns 2 (Snake eats the second food)
| |S|S|
| | |S|
snake.move("U"); -> Returns -1 (Game over because snake collides with border)
* */
// Console Output

/*
0
0
1
1
2
-1
*/



