package com.dsarmiento.ciclo3.reto3.web;

import com.dsarmiento.ciclo3.reto3.model.Reservation;
//import com.dsarmiento.ciclo3.reto3.reportes.ContadorClientes;
//import com.dsarmiento.ciclo3.reto3.reportes.StatusReservas;
import com.dsarmiento.ciclo3.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation r) {
        return reservationService.update(r);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservationService.deleteReservation(reservationId);
    }/*
     @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return reservationService.reporteStatusServicio();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
     public List<Reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
         return reservationService.reporteTiempoServicio(dateOne, dateTwo);
     }
     
     @GetMapping("/report-clients")
     public List<ContadorClientes> getClientes(){
         return reservationService.reporteClientesServicio();
     }*/
}
