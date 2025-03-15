import{$ as h,A as Ae,B as S,C as D,E as j,F as B,G as V,H as q,J as xe,K as Pe,M as z,N as G,O as H,P as U,Q as Y,_ as I,aa as Z,b as E,c as be,d as _e,e as ye,f as Ce,g as Se,h as Ie,j as Me,k as C,l as A,m as we,o as x,p as f,q as P,r as k,s as L,t as N,u as R,v as T,w as O,x as Fe,y as Ee}from"./chunk-WP6HWCCM.js";import{$ as ae,Cb as a,Db as o,Eb as u,Ec as y,Fb as te,Ha as ce,Ib as g,Kb as ie,U as re,Vb as l,W as F,Wb as w,Z as oe,Za as s,aa as Q,ab as ge,cb as p,da as le,db as fe,ea as me,fc as he,ja as $,jb as _,ka as ee,nb as v,pa as se,sa as de,ub as d,va as pe,vc as ve,za as ue}from"./chunk-CN4BVRTW.js";var ke="http://localhost:8080/",M=class r{constructor(e){this.http=e}login(e){return this.http.post(ke+"api/auth/login",e)}signup(e){return this.http.post(ke+"api/auth/signup",e)}static \u0275fac=function(t){return new(t||r)(ae(E))};static \u0275prov=F({token:r,factory:r.\u0275fac,providedIn:"root"})};function Ze(r,e){r&1&&(a(0,"mat-error"),l(1," Veuillez entrer un email valide. "),o())}function We(r,e){r&1&&(a(0,"mat-error"),l(1," Veuillez entrer un mot de passe valide. "),o())}var X=class r{constructor(e,t,i,n){this.fb=e;this.service=t;this.snackbar=i;this.router=n}loginForm;hidePassword=!0;ngOnInit(){this.loginForm=this.fb.group({email:["",[f.required,f.email]],password:["",[f.required,f.minLength(6)]]})}togglePasswordVisibility(){this.hidePassword=!this.hidePassword}login(){console.log(this.loginForm.value),this.service.login(this.loginForm.value).subscribe(e=>{if(console.log(e),e.userId!=null){let t={id:e.userId,role:e.userRole};h.saveUser(t),h.saveToken(e.jwt),h.isAdminLoggedIn()?this.router.navigateByUrl("/admin/dashboard"):h.isEtudiantLoggedIn()&&this.router.navigateByUrl("/etudiant/dashboard")}else this.snackbar.open("Invalid credentials","Close",{duration:5e3,panelClass:"error-snackbar"})})}static \u0275fac=function(t){return new(t||r)(p(O),p(M),p(Z),p(C))};static \u0275cmp=_({type:r,selectors:[["app-login"]],decls:25,vars:5,consts:[[1,"container"],[3,"ngSubmit","formGroup"],["appearance","outline",1,"form-field"],["matInput","","placeholder","Email","formControlName","email","required",""],[4,"ngIf"],["matInput","","formControlName","password","placeholder","Password","required","",3,"type"],["mat-icon-button","","matSuffix","",3,"click"],["mat-raised-button","","color","primary","type","submit",3,"click"],["mat-button","","color","accent","routerLink","/register"]],template:function(t,i){if(t&1&&(a(0,"div",0)(1,"mat-card")(2,"mat-card-header")(3,"mat-card-title"),l(4,"Login"),o()(),a(5,"mat-card-content")(6,"form",1),g("ngSubmit",function(){return i.login()}),a(7,"mat-form-field",2)(8,"mat-label"),l(9,"Email"),o(),u(10,"input",3),v(11,Ze,2,0,"mat-error",4),o(),a(12,"mat-form-field",2)(13,"mat-label"),l(14,"Mot de passe"),o(),u(15,"input",5),a(16,"button",6),g("click",function(){return i.togglePasswordVisibility()}),a(17,"mat-icon"),l(18),o()(),v(19,We,2,0,"mat-error",4),o(),a(20,"button",7),g("click",function(){return i.login()}),l(21,"Connexion"),o()()(),a(22,"mat-card-actions")(23,"button",8),l(24,"Vous n'avez pas de compte ? Inscrivez-vous"),o()()()()),t&2){let n,m;s(6),d("formGroup",i.loginForm),s(5),d("ngIf",((n=i.loginForm.get("email"))==null?null:n.invalid)&&((n=i.loginForm.get("email"))==null?null:n.touched)),s(4),d("type",i.hidePassword?"password":"text"),s(3),w(i.hidePassword?"visibility_off":"visibility"),s(),d("ngIf",((m=i.loginForm.get("password"))==null?null:m.invalid)&&((m=i.loginForm.get("password"))==null?null:m.touched))}},dependencies:[I,y,L,x,P,k,T,N,R,A,S,D,j,B,xe,q,Pe,V,U,z,G,H,Y],encapsulation:2})};function Xe(r,e){r&1&&(a(0,"mat-error"),l(1," Entrez un nom valide. "),o())}function Je(r,e){r&1&&(a(0,"mat-error"),l(1," Entrez un email valide. "),o())}function Ke(r,e){r&1&&(a(0,"mat-error"),l(1," Entrez un mot de passe valide. "),o())}function Qe(r,e){r&1&&(a(0,"mat-error"),l(1," Entrez un mot de passe de confirmation valide. "),o())}var J=class r{constructor(e,t,i,n,m){this.fb=e;this.service=t;this.snackbar=i;this.router=n;this.http=m}signupForm;hidePassword=!0;ngOnInit(){this.signupForm=this.fb.group({name:[null,[f.required]],password:[null,[f.required]],confirmPassword:[null,[f.required]],email:[null,[f.required,f.email]]})}togglePasswordVisibility(){this.hidePassword=!this.hidePassword}signup(){let e=this.signupForm.get("password")?.value,t=this.signupForm.get("confirmPassword")?.value;if(e!==t){this.snackbar.open("Les mdp ne correspondent pas!","fermer",{duration:5e3,panelClass:"error-snackbar"});return}console.log(this.signupForm.value),this.service.signup(this.signupForm.value).subscribe(i=>{console.log(i),i.id!=null?(this.snackbar.open("Inscription reussie","Close",{duration:5e3}),this.router.navigateByUrl("/login")):this.snackbar.open("Inscription faillie","Close",{duration:5e3,panelClass:"error-snackbar"})})}static \u0275fac=function(t){return new(t||r)(p(O),p(M),p(Z),p(C),p(E))};static \u0275cmp=_({type:r,selectors:[["app-signup"]],decls:34,vars:10,consts:[[1,"container"],[3,"ngSubmit","formGroup"],["appearance","outline"],["matInput","","placeholder","Enter your name","formControlName","name","required",""],[4,"ngIf"],["matInput","","placeholder","Email","required","","formControlName","email"],["matInput","","formControlName","password","placeholder","Password","required","",3,"type"],["mat-icon-button","","matSuffix","",3,"click"],["matInput","","placeholder","Confirm Password","required","","formControlName","confirmPassword",3,"type"],["mat-raised-button","","color","primary","type","submit",3,"disabled"]],template:function(t,i){if(t&1&&(a(0,"div",0)(1,"mat-card")(2,"mat-card-title"),l(3,"Inscription"),o(),a(4,"mat-card-content")(5,"form",1),g("ngSubmit",function(){return i.signup()}),a(6,"mat-form-field",2)(7,"mat-label"),l(8,"Name"),o(),u(9,"input",3),v(10,Xe,2,0,"mat-error",4),o(),a(11,"mat-form-field",2)(12,"mat-label"),l(13,"Email"),o(),u(14,"input",5),v(15,Je,2,0,"mat-error",4),o(),a(16,"mat-form-field",2)(17,"mat-label"),l(18,"Mot de passe"),o(),u(19,"input",6),a(20,"button",7),g("click",function(){return i.togglePasswordVisibility()}),a(21,"mat-icon"),l(22),o()(),v(23,Ke,2,0,"mat-error",4),o(),a(24,"mat-form-field",2)(25,"mat-label"),l(26,"Confirmer le mot de passe"),o(),u(27,"input",8),a(28,"button",7),g("click",function(){return i.togglePasswordVisibility()}),a(29,"mat-icon"),l(30),o()(),v(31,Qe,2,0,"mat-error",4),o(),a(32,"button",9),l(33,"Register"),o()()()()()),t&2){let n,m,c,b;s(5),d("formGroup",i.signupForm),s(5),d("ngIf",((n=i.signupForm.get("name"))==null?null:n.invalid)&&((n=i.signupForm.get("name"))==null?null:n.touched)),s(5),d("ngIf",((m=i.signupForm.get("email"))==null?null:m.invalid)&&((m=i.signupForm.get("email"))==null?null:m.touched)),s(4),d("type",i.hidePassword?"password":"text"),s(3),w(i.hidePassword?"visibility_off":"visibility"),s(),d("ngIf",((c=i.signupForm.get("password"))==null?null:c.invalid)&&((c=i.signupForm.get("password"))==null?null:c.touched)),s(4),d("type",i.hidePassword?"password":"text"),s(3),w(i.hidePassword?"visibility_off":"visibility"),s(),d("ngIf",((b=i.signupForm.get("confirmPassword"))==null?null:b.invalid)&&((b=i.signupForm.get("confirmPassword"))==null?null:b.touched)),s(),d("disabled",i.signupForm.invalid)}},dependencies:[I,y,L,x,P,k,T,N,R,S,D,j,B,q,V,U,z,G,H,Y,Ee,_e],styles:[".container[_ngcontent-%COMP%]{display:flex;justify-content:center;align-items:center;height:100vh}mat-card[_ngcontent-%COMP%]{max-width:400px;width:100%;padding:20px}@media screen and (max-width: 500px){mat-card[_ngcontent-%COMP%]{max-width:90%}}mat-card-title[_ngcontent-%COMP%]{text-align:center;font-size:24px;margin-bottom:20px}form[_ngcontent-%COMP%]{display:flex;flex-direction:column;align-items:center}mat-form-field[_ngcontent-%COMP%]{width:100%;margin-bottom:20px}button[_ngcontent-%COMP%]{width:100%}@media screen and (max-width: 500px){mat-card-title[_ngcontent-%COMP%]{font-size:20px}mat-form-field[_ngcontent-%COMP%]{margin-bottom:10px}}.error-snackbar[_ngcontent-%COMP%]{background-color:#f44336!important}"]})};var De=[{path:"login",component:X},{path:"register",component:J},{path:"",redirectTo:"/login",pathMatch:"full"},{path:"admin",loadChildren:()=>import("./chunk-3KF477PN.js").then(r=>r.AdminModule)},{path:"etudiant",loadChildren:()=>import("./chunk-O4MVKTJA.js").then(r=>r.EtudiantModule)}];var $e="@",et=(()=>{class r{doc;delegate;zone;animationType;moduleImpl;_rendererFactoryPromise=null;scheduler=null;injector=Q(se);loadingSchedulerFn=Q(tt,{optional:!0});_engine;constructor(t,i,n,m,c){this.doc=t,this.delegate=i,this.zone=n,this.animationType=m,this.moduleImpl=c}ngOnDestroy(){this._engine?.flush()}loadImpl(){let t=()=>this.moduleImpl??import("./chunk-QQO7GEVU.js").then(n=>n),i;return this.loadingSchedulerFn?i=this.loadingSchedulerFn(t):i=t(),i.catch(n=>{throw new re(5300,!1)}).then(({\u0275createEngine:n,\u0275AnimationRendererFactory:m})=>{this._engine=n(this.animationType,this.doc);let c=new m(this.delegate,this._engine,this.zone);return this.delegate=c,c})}createRenderer(t,i){let n=this.delegate.createRenderer(t,i);if(n.\u0275type===0)return n;typeof n.throwOnSyntheticProps=="boolean"&&(n.throwOnSyntheticProps=!1);let m=new ne(n);return i?.data?.animation&&!this._rendererFactoryPromise&&(this._rendererFactoryPromise=this.loadImpl()),this._rendererFactoryPromise?.then(c=>{let b=c.createRenderer(t,i);m.use(b),this.scheduler??=this.injector.get(de,null,{optional:!0}),this.scheduler?.notify(11)}).catch(c=>{m.use(n)}),m}begin(){this.delegate.begin?.()}end(){this.delegate.end?.()}whenRenderingDone(){return this.delegate.whenRenderingDone?.()??Promise.resolve()}componentReplaced(t){this._engine?.flush(),this.delegate.componentReplaced?.(t)}static \u0275fac=function(i){fe()};static \u0275prov=F({token:r,factory:r.\u0275fac})}return r})(),ne=class{delegate;replay=[];\u0275type=1;constructor(e){this.delegate=e}use(e){if(this.delegate=e,this.replay!==null){for(let t of this.replay)t(e);this.replay=null}}get data(){return this.delegate.data}destroy(){this.replay=null,this.delegate.destroy()}createElement(e,t){return this.delegate.createElement(e,t)}createComment(e){return this.delegate.createComment(e)}createText(e){return this.delegate.createText(e)}get destroyNode(){return this.delegate.destroyNode}appendChild(e,t){this.delegate.appendChild(e,t)}insertBefore(e,t,i,n){this.delegate.insertBefore(e,t,i,n)}removeChild(e,t,i){this.delegate.removeChild(e,t,i)}selectRootElement(e,t){return this.delegate.selectRootElement(e,t)}parentNode(e){return this.delegate.parentNode(e)}nextSibling(e){return this.delegate.nextSibling(e)}setAttribute(e,t,i,n){this.delegate.setAttribute(e,t,i,n)}removeAttribute(e,t,i){this.delegate.removeAttribute(e,t,i)}addClass(e,t){this.delegate.addClass(e,t)}removeClass(e,t){this.delegate.removeClass(e,t)}setStyle(e,t,i,n){this.delegate.setStyle(e,t,i,n)}removeStyle(e,t,i){this.delegate.removeStyle(e,t,i)}setProperty(e,t,i){this.shouldReplay(t)&&this.replay.push(n=>n.setProperty(e,t,i)),this.delegate.setProperty(e,t,i)}setValue(e,t){this.delegate.setValue(e,t)}listen(e,t,i,n){return this.shouldReplay(t)&&this.replay.push(m=>m.listen(e,t,i,n)),this.delegate.listen(e,t,i,n)}shouldReplay(e){return this.replay!==null&&e.startsWith($e)}},tt=new oe("");function je(r="animations"){return ue("NgAsyncAnimations"),le([{provide:ge,useFactory:(e,t,i)=>new et(e,t,i,r),deps:[ve,ye,pe]},{provide:ce,useValue:r==="noop"?"NoopAnimations":"BrowserAnimations"}])}var Be={providers:[he({eventCoalescing:!0}),we(De),Ie(Se()),je(),be(),me(Fe)]};function it(r,e){r&1&&(a(0,"div")(1,"mat-toolbar",1)(2,"span",2),l(3,"Plateform de suivi des projets"),o(),u(4,"span",3),a(5,"button",4),l(6,"S'inscrire"),o(),a(7,"button",5),l(8,"Se connecter"),o()()())}function nt(r,e){if(r&1){let t=te();a(0,"div")(1,"mat-toolbar",1)(2,"span",2),l(3,"Plateforme de suivi des projets"),o(),u(4,"span",3),a(5,"button",6),l(6,"Enseignant Dashboard"),o(),a(7,"button",7),l(8,"Affecter un projet"),o(),a(9,"button",8),g("click",function(){$(t);let n=ie();return ee(n.logout())}),l(10,"Logout"),o()()()}}function rt(r,e){if(r&1){let t=te();a(0,"div")(1,"mat-toolbar",1)(2,"span",2),l(3,"Task Management System"),o(),u(4,"span",3),a(5,"button",9),l(6,"Etudiant Dashboard"),o(),a(7,"button",8),g("click",function(){$(t);let n=ie();return ee(n.logout())}),l(8,"Logout "),o()()()}}var K=class r{constructor(e){this.router=e}title="Task_Angular_18";isAdminLoggedIn=h.isAdminLoggedIn();isEtudiantLoggedIn=h.isEtudiantLoggedIn();ngOnInit(){this.router.events.subscribe(e=>{this.isAdminLoggedIn=h.isAdminLoggedIn(),this.isEtudiantLoggedIn=h.isEtudiantLoggedIn()})}logout(){h.signout(),this.router.navigateByUrl("/login")}static \u0275fac=function(t){return new(t||r)(p(C))};static \u0275cmp=_({type:r,selectors:[["app-root"]],decls:4,vars:3,consts:[[4,"ngIf"],["color","primary",1,"navbar"],[1,"navbar-brand"],[1,"spacer"],["mat-button","","routerLink","/register","routerLinkActive","active"],["mat-button","","routerLink","/login","routerLinkActive","active"],["mat-button","","routerLink","/admin/dashboard","routerLinkActive","active"],["mat-button","","routerLink","/admin/projet/post","routerLinkActive","active"],["mat-button","","routerLinkActive","active",3,"click"],["mat-button","","routerLink","/etudiant/dashboard","routerLinkActive","active"]],template:function(t,i){t&1&&(v(0,it,9,0,"div",0)(1,nt,11,0,"div",0)(2,rt,9,0,"div",0),u(3,"router-outlet")),t&2&&(d("ngIf",!i.isAdminLoggedIn&&!i.isEtudiantLoggedIn),s(),d("ngIf",i.isAdminLoggedIn),s(),d("ngIf",i.isEtudiantLoggedIn))},dependencies:[Me,I,y,A,Ae,S],styles:[".navbar[_ngcontent-%COMP%]{display:flex;align-items:center;padding:0 16px;background-color:#1a237e;color:#fff}.navbar-brand[_ngcontent-%COMP%]{font-size:20px;font-weight:600;margin-right:16px}.spacer[_ngcontent-%COMP%]{flex:1}button[_ngcontent-%COMP%]{color:#fff!important;text-transform:uppercase;margin-left:8px}button.active[_ngcontent-%COMP%]{font-weight:600}.custom-toolbar[_ngcontent-%COMP%]{background-color:red}"]})};Ce(K,Be).catch(r=>console.error(r));
