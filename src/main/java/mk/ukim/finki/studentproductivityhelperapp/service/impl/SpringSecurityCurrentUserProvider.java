//package mk.ukim.finki.studentproductivityhelperapp.service.impl;
//
//import mk.ukim.finki.studentproductivityhelperapp.model.User;
//import mk.ukim.finki.studentproductivityhelperapp.service.CurrentUserProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SpringSecurityCurrentUserProvider implements CurrentUserProvider {
//
////    @Override
////    public User getCurrentUser() {
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////
////        if (auth != null && auth.isAuthenticated()) {
////            // Assuming your User object is stored in the principal of the Authentication object
////            User currentUser = (User) auth.getPrincipal();
////            return currentUser;
////        }
////
////        return null; // Or throw an exception if no user is authenticated
////    }
//
////    @Override
////    public String getCurrentUserEmail() {
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////
////        if (auth != null && auth.isAuthenticated()) {
////            // Assuming your User object is stored in the principal of the Authentication object
////            String currentEmail = auth.getPrincipal().toString();
////            return currentEmail;
////        }
////
////        return null; // Or throw an exception if no user is authenticated
////    }
////@Override
////public String getCurrentUserEmail() {
//////    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//////
//////    if (auth != null && auth.isAuthenticated()) {
//////        Object principal = auth.getPrincipal();
//////        if (principal instanceof UserDetails) {
//////            UserDetails userDetails = (UserDetails) principal;
//////            String currentEmail = userDetails.getUsername(); // Assuming email is the username
//////            return currentEmail;
//////        }
//////    }
////
////    return null; // Or throw an exception if no user is authenticated
////}
//
////    @Override
////    public String getCurrentUserEmail() {
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////
////        if (auth != null && auth.isAuthenticated()) {
////            Object principal = auth.getPrincipal();
////            if (principal instanceof User) {
////                User currentUser = (User) principal;
////                String currentEmail = currentUser.getEmail();
////                return currentEmail;
////            }
////        }
////
////        return null; // Or throw an exception if no user is authenticated
////    }
//@Override
//public String getCurrentUserEmail() {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    if (authentication != null && authentication.isAuthenticated()) {
//        return authentication.getPrincipal().toString();
//    }
//    return null;
//}
//
//
//}
