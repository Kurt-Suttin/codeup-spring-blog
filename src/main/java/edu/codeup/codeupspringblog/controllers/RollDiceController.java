package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String getAllDiceValues(@PathVariable int number, Model model) {
        int diceRoll = genRandomNumber();
        String resultOfRoll = showGuessResult(diceRoll,number);
        model.addAttribute("diceRoll",diceRoll);
        model.addAttribute("result",resultOfRoll);
        model.addAttribute("userGuess", number);
        return "roll-dice";
    }

    public int genRandomNumber() {

        Random random = new Random();
        int randomNumber = random.nextInt(6) + 1;
        return randomNumber;
    }

    public String showGuessResult(int CorrectNum, int userGuess) {
        if (CorrectNum == userGuess) {
            return "You guessed right";
        } else return "Your guess is incorrect";
    }

}
