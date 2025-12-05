Player1=input("enter player1 name: ")
Player2=input("enter player2 name: ")

player1_turn=input(Player1+" enter your choice rock,scissors or paper: ")
player2_turn=input(Player2+" enter your choice rock,scissors or paper: ")

if player1_turn == player2_turn:
    print("It's a tie!")
elif player1_turn == 'rock':
    if player2_turn == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif player1_turn == 'scissors':
    if player2_turn == 'paper':
        print("Scissors win!")
    else:
        print("Rock wins!")
elif player1_turn == 'paper':
    if player2_turn == 'rock':
        print("Paper wins!")
    else:
        print("Scissors win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")