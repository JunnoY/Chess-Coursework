package chess;

public class CheckInput {
	
	public static boolean checkCoordinateValidity(String input){
			boolean validform = false;

			if(input.length()==2){
				if((input.charAt(0)==('1')|input.charAt(0)==('2')|
			input.charAt(0)==('3')|input.charAt(0)==('4')|input.charAt(0)==('5')|input.charAt(0)==('6')
			|input.charAt(0)==('7')|input.charAt(0)==('8'))&&(input.charAt(1)==('a')|input.charAt(1)==('b')|input.charAt(1)==('c')|input.charAt(1)==('d')|input.charAt(1)==('e')|input.charAt(1)==('f')|
									input.charAt(1)==('g')|input.charAt(1)==('h'))){
					validform = true;
				}
				
			}
			else{
				validform = false;
			}

			return validform;
		
		}
	}
