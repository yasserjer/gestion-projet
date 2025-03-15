import{$ as w,B as ot,C as rt,E as at,F as b,G as pt,H as ct,I as mt,K as dt,L as st,M as lt,P as gt,Q as ut,V as h,X as ft,Y as Ct,Z as Mt,_ as S,a as L,aa as y,b as U,i as q,k as W,l as Y,m as J,o as K,p as Q,q as X,r as Z,s as tt,t as et,u as nt,w as it}from"./chunk-WP6HWCCM.js";import{$ as H,Cb as i,Db as e,Dc as x,Eb as s,Ec as G,Fb as T,Gc as v,Hc as $,Ib as C,Kb as g,Nb as V,Ub as A,Vb as o,W as B,Wb as c,X as N,Xb as z,Za as a,bc as M,cb as m,cc as j,ja as D,jb as O,ka as k,kb as R,nb as l,ub as d}from"./chunk-CN4BVRTW.js";var _="http://localhost:8080/",u=class r{constructor(n){this.http=n}getProjetsbyUserId(){return this.http.get(_+`api/etudiant/projets/${w.getUserId()}`,{headers:this.createAuthorizationHeader()})}getProjetbyId(n){return this.http.get(_+`api/etudiant/projet/${n}`,{headers:this.createAuthorizationHeader()})}getCommentsByProjetId(n){return this.http.get(_+`api/etudiant/projet/${n}/comments`,{headers:this.createAuthorizationHeader()})}createComment(n,t){let p={projetId:n,postedBy:w.getUserId()};return this.http.post(_+"api/etudiant/projet/comment",t,{params:p,headers:this.createAuthorizationHeader()})}updateProjet(n,t){return this.http.get(_+`api/etudiant/projet/${n}/${t}`,{headers:this.createAuthorizationHeader()})}createAuthorizationHeader(){return new L().set("Authorization","Bearer "+w.getToken())}static \u0275fac=function(t){return new(t||r)(H(U))};static \u0275prov=B({token:r,factory:r.\u0275fac,providedIn:"root"})};function wt(r,n){if(r&1){let t=T();i(0,"mat-card",3)(1,"div",4)(2,"h2",5),o(3),e(),i(4,"p",6),o(5),e(),s(6,"mat-divider"),i(7,"div",7)(8,"div",8)(9,"span",9),o(10,"Date due:"),e(),i(11,"span",10),o(12),M(13,"date"),e()(),i(14,"div",8)(15,"span",9),o(16,"Etudiant:"),e(),i(17,"span",10),o(18),e()(),i(19,"div",8)(20,"span",9),o(21,"Priorite:"),e(),i(22,"span",10),o(23),e()(),i(24,"div",8)(25,"span",9),o(26,"Statut:"),e(),i(27,"span",10),o(28),e()()(),s(29,"mat-divider"),i(30,"div",11)(31,"button",12)(32,"mat-icon"),o(33,"visibility"),e()(),i(34,"button",13)(35,"mat-icon"),o(36,"edit"),e()(),i(37,"mat-menu",null,0)(39,"button",14),C("click",function(){let f=D(t).$implicit,P=g();return k(P.updateStatus(f.id,"INPROGRESS"))}),o(40,"INPROGRESS"),e(),i(41,"button",14),C("click",function(){let f=D(t).$implicit,P=g();return k(P.updateStatus(f.id,"COMPLETED"))}),o(42,"COMPLETED"),e()()()()()}if(r&2){let t=n.$implicit,p=A(38);a(3),c(t.title),a(2),c(t.description),a(7),c(j(13,9,t.dueDate,"MMM, d, y")),a(6),c(t.etudiantName),a(5),c(t.priority),a(5),c(t.projetStatus),a(3),V("routerLink","/etudiant/projet/",t.id,"/view"),a(3),d("matMenuTriggerFor",p)}}var E=class r{constructor(n,t){this.service=n;this.snackbar=t}listOfProjets=[];ngOnInit(){this.getProjets()}getProjets(){this.service.getProjetsbyUserId().subscribe(n=>{console.log(n),this.listOfProjets=n})}updateStatus(n,t){this.service.updateProjet(n,t).subscribe(p=>{p.id!=null?(this.snackbar.open("Projet updated successfully","Close",{duration:5e3}),this.getProjets()):this.snackbar.open("Something went wrong","Close",{duration:5e3})})}static \u0275fac=function(t){return new(t||r)(m(u),m(y))};static \u0275cmp=O({type:r,selectors:[["app-etudiant-dashboard"]],decls:2,vars:1,consts:[["statusMenu","matMenu"],[1,"projet-list"],["class","projet-card",4,"ngFor","ngForOf"],[1,"projet-card"],[1,"projet-details"],[1,"projet-name"],[1,"projet-description"],[1,"projet-info"],[1,"info-row"],[1,"info-label"],[1,"info-value"],[1,"actions"],["mat-icon-button","","color","accent",1,"view-button",3,"routerLink"],["mat-icon-button","","color","primary",1,"update-button",3,"matMenuTriggerFor"],["mat-menu-item","",3,"click"]],template:function(t,p){t&1&&(i(0,"div",1),l(1,wt,43,12,"mat-card",2),e()),t&2&&(a(),d("ngForOf",p.listOfProjets))},dependencies:[S,x,Y,rt,at,b,h,Ct,ft,Mt,v],styles:[".projet-list[_ngcontent-%COMP%]{display:flex;flex-wrap:wrap;justify-content:space-between;background-color:#f8f8f8;min-height:37vh;padding:20px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]{width:calc(33.33% - 20px);margin-bottom:20px;border-radius:10px;box-shadow:0 2px 6px #0003}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]{padding:20px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-name[_ngcontent-%COMP%]{font-size:20px;font-weight:700;color:#108eee;margin-bottom:10px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-description[_ngcontent-%COMP%]{margin-bottom:10px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-info[_ngcontent-%COMP%]{display:flex;flex-wrap:wrap;margin-bottom:10px;margin-top:10px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-info[_ngcontent-%COMP%]   .info-row[_ngcontent-%COMP%]{flex:0 0 50%;display:flex;align-items:center;margin-bottom:8px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-info[_ngcontent-%COMP%]   .info-row[_ngcontent-%COMP%]   .info-label[_ngcontent-%COMP%]{font-weight:400;margin-right:5px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-info[_ngcontent-%COMP%]   .info-row[_ngcontent-%COMP%]   .info-value[_ngcontent-%COMP%]{font-weight:700}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]{display:flex;justify-content:flex-end;margin-top:10px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]   .update-button[_ngcontent-%COMP%], .projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]   .view-button[_ngcontent-%COMP%]{margin-right:10px}"]})};function yt(r,n){if(r&1&&(i(0,"mat-card",11)(1,"div",12)(2,"h2",13),o(3),e(),i(4,"p",14),o(5),e(),s(6,"mat-divider"),i(7,"div",15)(8,"div",16)(9,"span",17),o(10,"Due Date:"),e(),i(11,"span",18),o(12),M(13,"date"),e()(),i(14,"div",16)(15,"span",17),o(16,"Etudiant:"),e(),i(17,"span",18),o(18),e()(),i(19,"div",16)(20,"span",17),o(21,"Priority:"),e(),i(22,"span",18),o(23),e()(),i(24,"div",16)(25,"span",17),o(26,"Status:"),e(),i(27,"span",18),o(28),e()()()()()),r&2){let t=g(2);a(3),c(t.projetData.title),a(2),c(t.projetData.description),a(7),c(j(13,6,t.projetData.dueDate,"MMM d, y")),a(6),c(t.projetData.etudiantName),a(5),c(t.projetData.priority),a(5),c(t.projetData.projetStatus)}}function Et(r,n){if(r&1&&(i(0,"div",8)(1,"div",9),l(2,yt,29,9,"mat-card",10),e()()),r&2){let t=g();a(2),d("ngIf",t.projetData)}}function It(r,n){if(r&1&&(i(0,"mat-card",6)(1,"mat-card-header"),s(2,"div",19),i(3,"mat-card-title"),o(4),e(),i(5,"mat-card-subtitle"),o(6),M(7,"date"),e()(),i(8,"mat-card-content"),o(9),e()()),r&2){let t=n.$implicit;a(4),c(t.postedName),a(2),c(j(7,3,t.createdAt,"medium")),a(3),z(" ",t.content," ")}}var I=class r{constructor(n,t,p,f,P){this.service=n;this.fb=t;this.router=p;this.snackbar=f;this.activatedRoute=P}id;commentForm;projetData;comments;ngOnInit(){this.id=this.activatedRoute.snapshot.params.id,this.commentForm=this.fb.group({content:[null,[Q.required]]}),this.getProjetById()}getProjetById(){this.service.getProjetbyId(this.id).subscribe(n=>{console.log(n),this.projetData=n,this.getCommentsByProjetId()})}publishComment(){this.service.createComment(this.id,this.commentForm.get("content")?.value).subscribe(n=>{console.log(n),n.id!=null?(this.snackbar.open("Comment published successfully","Close",{duration:5e3}),this.getCommentsByProjetId()):this.snackbar.open("Something went wrong","Error",{duration:5e3})})}getCommentsByProjetId(){this.service.getCommentsByProjetId(this.id).subscribe(n=>{console.log(n),this.comments=n})}static \u0275fac=function(t){return new(t||r)(m(u),m(it),m(W),m(y),m(q))};static \u0275cmp=O({type:r,selectors:[["app-view-projet-details"]],decls:17,vars:4,consts:[["class","card-container",4,"ngIf"],[1,"comment-card"],[3,"formGroup"],["appearance","outline"],["matInput","","formControlName","content"],["mat-raised-button","","color","primary",2,"float","right",3,"click","disabled"],[2,"margin-top","10px"],["style","margin-top: 10px;",4,"ngFor","ngForOf"],[1,"card-container"],[1,"projet-list"],["class","projet-card",4,"ngIf"],[1,"projet-card"],[1,"projet-details"],[1,"projet-name"],[1,"projet-description"],[1,"projet-info"],[1,"info-row"],[1,"info-label"],[1,"info-value"],["mat-card-avatar","",1,"example-header-image"]],template:function(t,p){t&1&&(l(0,Et,3,1,"div",0),i(1,"mat-card",1)(2,"mat-card-content")(3,"h4"),o(4,"Publier votre commentaire"),e(),i(5,"div")(6,"form",2)(7,"mat-form-field",3)(8,"mat-label"),o(9,"Contenu"),e(),s(10,"textarea",4),e(),i(11,"button",5),C("click",function(){return p.publishComment()}),o(12,"Publish Comment"),e()()()(),i(13,"div",6)(14,"h4"),o(15,"Comments"),e(),l(16,It,10,6,"mat-card",7),e()()),t&2&&(d("ngIf",p.projetData),a(6),d("formGroup",p.commentForm),a(5),d("disabled",!p.commentForm.valid),a(5),d("ngForOf",p.comments))},dependencies:[S,x,G,tt,K,X,Z,et,nt,ot,b,st,ct,dt,mt,pt,gt,lt,h,ut,v],styles:[".projet-list[_ngcontent-%COMP%]{display:flex;flex-wrap:wrap;justify-content:space-between;min-height:37vh}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]{margin-bottom:20px;width:100%;border-radius:10px;box-shadow:0 2px 6px #0003}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]{padding:20px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-name[_ngcontent-%COMP%]{font-size:20px;font-weight:700;color:#108ee9;margin-bottom:10px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-description[_ngcontent-%COMP%]{margin-bottom:10px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-info[_ngcontent-%COMP%]{display:flex;flex-wrap:wrap;margin-bottom:10px;margin-top:10px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-info[_ngcontent-%COMP%]   .info-row[_ngcontent-%COMP%]{flex:0 0 50%;display:flex;align-items:center;margin-bottom:8px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-info[_ngcontent-%COMP%]   .info-row[_ngcontent-%COMP%]   .info-label[_ngcontent-%COMP%]{font-weight:400;margin-right:5px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .projet-info[_ngcontent-%COMP%]   .info-row[_ngcontent-%COMP%]   .info-value[_ngcontent-%COMP%]{font-weight:700}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]{display:flex;justify-content:flex-end;margin-top:10px}.projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]   .update-button[_ngcontent-%COMP%], .projet-list[_ngcontent-%COMP%]   .projet-card[_ngcontent-%COMP%]   .projet-details[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]   .view-button[_ngcontent-%COMP%]{margin-right:10px}.card-container[_ngcontent-%COMP%]{margin:16px;max-width:60%;padding-bottom:30px}mat-card[_ngcontent-%COMP%]{padding:10px}.example-header-image[_ngcontent-%COMP%]{background-image:url(https://images.unsplash.com/photo-1728823422978-6066e6d32d56?q=80&w=1932&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D);background-size:cover}mat-card-content[_ngcontent-%COMP%]{margin-top:10px}mat-card-footer[_ngcontent-%COMP%]{margin-left:20px}.img[_ngcontent-%COMP%]{object-fit:cover}.comment-card[_ngcontent-%COMP%]{margin-top:20px}mat-form-field[_ngcontent-%COMP%]{width:100%}"]})};var Dt=[{path:"dashboard",component:E},{path:"projet/:id/view",component:I}],_t=class r{static \u0275fac=function(t){return new(t||r)};static \u0275mod=R({type:r});static \u0275inj=N({providers:[J(Dt)],imports:[$]})};export{_t as EtudiantModule};
