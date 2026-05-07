// AccountController.java

package net.javaguides.banking_app.controller;

import lombok.AllArgsConstructor;
import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class AccountContoller {

    private AccountService accountService;

    // Create Account
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(
            @RequestBody AccountDto accountDto
    ){

        AccountDto savedAccount =
                accountService.createAccount(accountDto);

        return ResponseEntity.ok(savedAccount);
    }

    // Get Account
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(
            @PathVariable Long id
    ){

        AccountDto accountDto =
                accountService.getAccountById(id);

        return ResponseEntity.ok(accountDto);
    }

    // Deposit
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(
            @PathVariable Long id,
            @RequestParam double amount
    ){

        AccountDto accountDto =
                accountService.deposit(id, amount);

        return ResponseEntity.ok(accountDto);
    }

    // Withdraw
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(
            @PathVariable Long id,
            @RequestParam double amount
    ){

        AccountDto accountDto =
                accountService.withdraw(id, amount);

        return ResponseEntity.ok(accountDto);
    }
}