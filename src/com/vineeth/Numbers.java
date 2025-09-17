package com.vineeth;

public class Numbers {

	
	public void evenOrOddNumber(int n){
		if(n==0){
			System.out.println(n + " is a Whole number");
		}else if(n%2==0){
			System.out.println(n + " is a Even number");
		}else{
			System.out.println(n+" is a Odd number");
		}
	}
	
	public void isPrime(int n){
		int count =0;
		if(n==0 || n==1){
			count++;
		}else{
			for(int i=2;i<=n/2;i++){
				if(n%i==0){
					count++;
				}
			}
		}

		if(count<1){
			System.out.println(n+" is a prime number");
		}else{
			System.out.println(n+ " is not a prime number");
		}
		count=0;
	}
	
	public void primeNumbers(int n){
		int count =0;
		if(n==0 || n==1){
			count++;
		}
		for(int i=2;i<=n;i++){
			for(int j=2;j<=i/2;j++){
				if(i%j==0){
					count++;
				}
			}
			if(count<1){
				System.out.print(i+" ");
			}
			count=0;
		}
		
	}
	
	public void swapNumber(int a, int b){
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("\nswapped number are "+a+"&"+b);
	}
	
	public void reverseNumber(int x){
		int rem, rev = 0;
		if(x==0){
			return ;
		}
		while(x>0){
			rem = x%10;
			rev = rev*10+rem;
			x = x/10;
		}
		System.out.println(rev);
		
	}
	
	public void fibnacciSeries(int n){
		int a = 0, b = 1, c = 0;
		for(int i=1;i<n;i++){
			System.out.print(a+" ");
			c = a+b;
			a = b;
			b = c;
		}
		System.out.print("\n");
	}
	
	public void armStrongNumebr(int n){
		int a = 0,x = 0;
		int target = n;
		while(n>0){
			x = n%10;
			a += x*x*x;
			n = n/10;
		}
		if(target==a){
			System.out.println("It is a armstong number");
		}
	}

	public void digitSum(int i) {
		int a=0,b=0;
		while(i>0){
			a = i%10;
			b +=a;
			i = i/10;
		}
		System.out.println(b);
	}

	public void digitProduct(int i) {
		int a=0,b=1;
		while(i>0){
			a = i%10;
			b *=a;
			i = i/10;
		}
		System.out.println(b);
	}

	public int factorialNumber(int i) {
		if(i==0){
			return 1;
		}
		return i*factorialNumber(i-1);
	}
}
