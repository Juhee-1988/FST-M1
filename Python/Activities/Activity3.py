user1=input("Enter Player1 name: ")
user2=input("Enter Player2 name: ")
user1_ans=input(user1 +", Do you want to choose rock, paper or scissors? ").lower()
user2_ans=input(user2 +", Do you want to choose rock, paper or scissors? ").lower()
if user1_ans==user2_ans:
    print("It's a tie!")
elif user1_ans=="rock":
    if user2_ans=="paper":
        print("Paper wins!")
    elif user2_ans=="scissors":
        print("Rock wins!")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again")
elif user1_ans=="paper":
    if user2_ans=="scissors":
        print("Scissors win!")
    elif user2_ans=="rock":
        print("Paper wins!")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again")
elif user1_ans=="scissors":
    if user2_ans=="rock":
        print("Rock wins!")
    elif user2_ans=="paper":
        print("Scissors win")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again")        
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again")